package kyul.springbasic.core;

import kyul.springbasic.core.discount.FixDiscountPolicy;
import kyul.springbasic.core.member.MemberService;
import kyul.springbasic.core.member.MemberServiceImpl;
import kyul.springbasic.core.member.MemoryMemberRepository;
import kyul.springbasic.core.order.OrderService;
import kyul.springbasic.core.order.OrderServiceImpl;

public class AppConfig {

    // 애플리케이션의 전체 동작 방식을 구성. 구현 객체 생성, 연결하는 책임 가진 별도의 설정 클래스

    /* 생성자 주입 */
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
