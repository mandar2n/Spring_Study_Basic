package kyul.springbasic.core.member;

public class MemberServiceImpl implements MemberService{

/*  구체에 의존하고 있음. DIP 위반!!
    private final MemberRepository memberRepository = new MemoryMemberRepository();
*/

    // 생성자 통해 memberRepository의 구현체로 무엇이 올 지 결정해야 함
    private final MemberRepository memberRepository; //MemberRepository, 즉 추상(인터페이스)에만 의존하게 됨. DIP 지킬 수 있음

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
