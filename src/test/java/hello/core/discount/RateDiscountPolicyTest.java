package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPalicy discountPolicy;
    @BeforeEach
    public void beforeEach(){

        AppConfig appConfig = new AppConfig();
        discountPolicy = appConfig.discountPalicy();

    }

    @Test
    @DisplayName("VIP는 10프로 할인")
    void vip_0(){

        Member member = new Member(1L, "hwh", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP 아님")
    void vip_X(){

        Member member = new Member(2L, "hwhX", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }

}