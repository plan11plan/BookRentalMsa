package com.msa.bestBook.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    public Long pointValue;

    public Long addPoint(Long point){
        this.setPointValue(this.pointValue+point);
        return this.pointValue;
    }

    public Long removePoint(Long point)throws Exception{
        if(point> this.pointValue){
            throw new Exception("이거 빼면 포인트가 마이너스 되요");
        }
        this.setPointValue(this.pointValue-point);
        return this.pointValue;
    }

    public static Point createPoint()
    {
        return new Point(0L);
    }
    public static Point sample(){
        return new Point(10L);
    }

}
