package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member1 = new Member(1L, "member1", Grade.VIP);
        memberService.join(member1);

        Member fideMember = memberService.findMember(1L);
        System.out.println("new member = " +member1.getName() );
        System.out.println("fideMember = " +fideMember.getName() );

        System.out.println("new member = " +member1.getId() );
        System.out.println("fideMember = " +fideMember.getGrade() );

    }
}
