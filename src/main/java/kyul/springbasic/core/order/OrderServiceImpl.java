package kyul.springbasic.core.order;

import kyul.springbasic.core.discount.DiscountPolicy;
import kyul.springbasic.core.discount.FixDiscountPolicy;
import kyul.springbasic.core.discount.RateDiscountPolicy;
import kyul.springbasic.core.member.Member;
import kyul.springbasic.core.member.MemberRepository;
import kyul.springbasic.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{


/*  DIP 위반 사항

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 구체에도 의존중임!!!!! DIP 위반!!!!!
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 이렇게 바꿔주어야 하는 게 OCP 위반!!!!!
    private DiscountPolicy discountPolicy; // 이렇게 수정하면, 더이상 구체에 의존하지 않고 추상에만 의존하게 됨. 하지만 구체가 없다는 게 문제.*/


    /* 생성자 주입 통한 위의 문제 해결. DIP 지키게 됨 */
    // final이면 생성자로든 무조건 할당이 되어야 함
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 단일 체계 원칙 잘 지켜짐
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
