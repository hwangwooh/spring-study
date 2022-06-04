package hello.core.discount;

import hello.core.anntation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // 우선 순위 1위
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPalicy{

    private int discountPolicy = 10;

    @Override
    public int discount(Member member, int price) {
       if(member.getGrade() == Grade.VIP){
           return price * discountPolicy / 100;


       }else{

           return 0;
       }
    }
}
