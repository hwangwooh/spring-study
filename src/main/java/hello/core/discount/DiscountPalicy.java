package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPalicy {
    /**
     *
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);



}
