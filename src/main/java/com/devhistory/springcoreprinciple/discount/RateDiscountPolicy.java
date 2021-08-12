package com.devhistory.springcoreprinciple.discount;

import com.devhistory.springcoreprinciple.member.Grade;
import com.devhistory.springcoreprinciple.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}