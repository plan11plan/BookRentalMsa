package com.msa.member.domain;


import com.msa.member.domain.vo.Authority;
import com.msa.member.domain.vo.Email;
import com.msa.member.domain.vo.IDName;
import com.msa.member.domain.vo.Password;
import com.msa.member.domain.vo.Point;
import com.msa.member.domain.vo.UserRole;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;
    @Embedded
    private IDName idName;
    @Embedded
    private Password password;
    @Embedded
    private Email email;

    @ElementCollection
    private List<Authority> authorities = new ArrayList<Authority>();
    @Embedded
    private Point point;

    public static Member registerMember(IDName idName, Password pwd, Email email) {
        Member member = new Member();
        member.setIdName(idName);
        member.setPassword(pwd);
        member.setEmail(email);
        member.setPoint(Point.createPoint());
        member.addAuthority(new Authority(UserRole.USER));
        return member;

    }

    public long savePoint(long point) {
        return this.point.addPoint(point);
    }

    public long usePoint(long point) throws Exception {
        return this.point.removePoint(point);
    }

    private void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public Member login(IDName idName, Password password) {
        return this;
    }

    public void logout(IDName idName) {
    }
}
