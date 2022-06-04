package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPalicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void  findAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "user1", Grade.VIP);
        int discountPolicy = discountService.discount(member, 10000, "fixDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPolicy).isEqualTo(1000);

        int discountPolicy2 = discountService.discount(member, 20000, "rateDiscountPolicy");
       // assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPolicy2).isEqualTo(2000);



    }

    static class DiscountService{
        private final Map<String, DiscountPalicy> policyMap;
        private final List<DiscountPalicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPalicy> policyMap,
                               List<DiscountPalicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);

    }

        public int discount(Member member, int i, String discountCode) {
            DiscountPalicy discountPalicy = policyMap.get(discountCode);
            return discountPalicy.discount(member, i);

        }
    }
}
