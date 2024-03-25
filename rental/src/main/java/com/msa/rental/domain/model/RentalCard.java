package com.msa.rental.domain.model;


import com.msa.rental.domain.model.vo.IDName;
import com.msa.rental.domain.model.vo.Item;
import com.msa.rental.domain.model.vo.LateFee;
import com.msa.rental.domain.model.vo.RentStatus;
import com.msa.rental.domain.model.vo.RentalCardNo;
import com.msa.rental.domain.model.vo.ReturnItem;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class RentalCard {


    //Key이기 때문에 직렬화를 해줘야함
    @EmbeddedId
    private RentalCardNo rentalCardNo;
    @Embedded
    private IDName member;


    private RentStatus rentStatus;
    @Embedded
    private LateFee lateFee;

    /**
     * @ElementCollection
     * 컬렉션 객체임을 JPA가 알 수 있게 하게 한다.
     * 엔티티가 아닌 값 타입, 임베디드 타입에 대한 테이블을 생성하고 1대다 관계로 다룬다.
     * 기본 LAZY
     *
     * @CollectionTable
     * 값 타입 컬렉션을 매핑할 테이블에 대한 역할을 지정하는 데 사용한다.
     * 테이블의 이름과 조인정보를 적어줘야 한다.
     */
    @ElementCollection
    private List<RentalItem> rentalItemList = new ArrayList<RentalItem>();
    @ElementCollection
    private List<ReturnItem> returnItemList = new ArrayList<ReturnItem>();

    public static RentalCard sample() {
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardNo(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(IDName.sample());
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setLateFee(LateFee.sample());
        return rentalCard;
    }

    private void addRentalItem(RentalItem rentalItem) {
        this.rentalItemList.add(rentalItem);
    }

    private void removeRentalItem(RentalItem rentalItem) {
        this.rentalItemList.remove(rentalItem);
    }

    private void addReturnItem(ReturnItem returnItem) {
        this.returnItemList.add(returnItem);
    }

    //대여카드 생성
    public static RentalCard createRentalCard(IDName creator) {
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardNo(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(creator);
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setLateFee(LateFee.createLateFee());
        return rentalCard;
    }

    public RentalCard rentItem(Item item) {
        checkRentalAvailable();
        this.addRentalItem(RentalItem.createRentalItem(item));
        return this;
    }

    /**
     * 사용자는 대여가능한 도서를 대여할 수 있다.(대여 조건은 2주, 1인당 5권 이내이다)
     */
    private void checkRentalAvailable() {
        if (this.rentStatus == RentStatus.RENT_UNAVAILABLE) {
            throw new IllegalStateException("대여불가상태입니다.");
        }
        if (this.rentalItemList.size() > 5) {
            throw new IllegalArgumentException("이미 5권을 대여했습니다.");
        }
    }

    /**
     * 반납시 연체료가 계산됨
     */
    public RentalCard returnItem(Item item, LocalDate returnDate) {
        RentalItem rentalItem = this.rentalItemList.stream().filter(i -> i.getItem().equals(item)).findFirst().get();
        calculateLateFee(rentalItem, returnDate);
        this.addReturnItem(ReturnItem.createReturnItem(rentalItem));
        this.removeRentalItem(rentalItem);
        return this;
    }

    /**
     * 반납되지 않고 대여 기간이 지난 도서는 연체된다. 연체 시 연체 포인트가 1일 10포인트 부여된다
     */
    private void calculateLateFee(RentalItem rentalItem, LocalDate returnDate) {
        if (returnDate.compareTo(rentalItem.getOverdueDate()) > 0) {
            long point = Period.between(rentalItem.getOverdueDate(), returnDate).getDays() * 10;
            LateFee addPoint = this.lateFee.addPoint(point);
            this.lateFee.setPoint(addPoint.getPoint());
        }
    }

    public RentalCard overdueItem(Item item) {
        RentalItem rentalItem = this.rentalItemList.stream().filter(i -> i.getItem().equals(item)).findFirst().get();
        rentalItem.setOverdued(true);
        this.rentStatus = RentStatus.RENT_UNAVAILABLE;
        rentalItem.setOverdueDate(LocalDate.now().minusDays(1));
        return this;
    }

    /**
     * 포인트를 활용하여 대여 정지를 해제할 수 있다. 포인트는 연체료를 감면할 수 있다. 연체포인트를 0으로 만들면 대출 가능 상태가 된다.
     */
    public Long makeAvailableRental(Long point) throws Exception {
        if (this.rentalItemList.size() != 0) {
            throw new IllegalArgumentException("모든 도서가 반납되어야 정지를 해제가능");
        }
        if (this.getLateFee().getPoint() != point) {
            throw new IllegalArgumentException("해당 포인트로 연체를 해제할 수 없습니다.");
        }
        this.setLateFee(lateFee.removePoint(point));

        if(this.getLateFee().getPoint()==0){
            this.rentStatus = RentStatus.RENT_AVAILABLE;
        }

        return this.getLateFee().getPoint();
    }


}
