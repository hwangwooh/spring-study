package hello.core.xml;

import hello.core.member.MemberService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.support.GenericXmlContextLoader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class xmlAppContext {

    @Test
    void xmlAppcontext(){

        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberservice = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberservice).isInstanceOf(MemberService.class);

        

    }


    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        MemberService memberService = ac.getBean("memberService",  MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
