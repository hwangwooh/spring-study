package hello.core.member;

public interface MemberRepository {

    void save(Member member);// 회원 저장

    Member finById(Long memberId); // 저장 된 곳에서 회원 찾기

}
