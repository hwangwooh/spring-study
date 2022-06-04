package hello.core.order;

import hello.core.anntation.MainDiscountPolicy;
import hello.core.discount.DiscountPalicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
/*
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPalicy discountPalicy) {
        this.memberRepository = memberRepository;
        this.discountPalicy = discountPalicy;
    } 가 만들어짐
*/
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    public final DiscountPalicy discountPalicy;

    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPalicy discountPalicy) {
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
