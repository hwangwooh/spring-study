package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPalicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    @Test
    @DisplayName("부모 타입조회시 자식둘이라 오류")
    void DiscountPalicy(){

        //DiscountPalicy bean = ac.getBean(DiscountPalicy.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPalicy.class));
    }

    @Test
    @DisplayName("부모 타입조회시 자식둘이라 오류 > 이름 지정")
    void DiscountPalicyName(){

        DiscountPalicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPalicy.class);
        org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입조회시 자식둘이라 오류 > 하위 타입으로 > 안좋은 방법")
    void DiscountPalicyName2(){

        DiscountPalicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
        org.assertj.core.api.Assertions.assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }


    @Test
    @DisplayName("부모 타입조회시 자식둘이라 오류 > 하위 타입으로 > 안좋은 방법")
    void DiscountPalicyName3(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("s  = " + s +"    value = " + beansOfType.get(s));
            
        }
        

    }



    @Configuration
    static class TestConfig{

        @Bean
        public DiscountPalicy rateDiscountPolicy(){

            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPalicy fixDiscountPolicy(){

            return new FixDiscountPolicy();
        }
    }


}
