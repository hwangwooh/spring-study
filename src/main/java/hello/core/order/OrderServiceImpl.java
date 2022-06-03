package hello.core.order;

import hello.core.discount.DiscountPalicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    public final DiscountPalicy discountPalicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPalicy discountPalicy) {
        this.memberRepository = memberRepository;
        this.discountPalicy = discountPalicy;
    }


    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.finById(memberID);
        int discountPrice = discountPalicy.discount(member, itemPrice);
        return new Order(memberID, itemName,itemPrice, discountPrice);


    }
}
