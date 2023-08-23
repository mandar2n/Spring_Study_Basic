package kyul.springbasic.core;

import kyul.springbasic.core.discount.DiscountPolicy;
import kyul.springbasic.core.discount.FixDiscountPolicy;
import kyul.springbasic.core.discount.RateDiscountPolicy;
import kyul.springbasic.core.member.MemberRepository;
import kyul.springbasic.core.member.MemberService;
import kyul.springbasic.core.member.MemberServiceImpl;
import kyul.springbasic.core.member.MemoryMemberRepository;
import kyul.springbasic.core.order.OrderService;
import kyul.springbasic.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 애플리케이션의 전체 동작 방식을 구성. 구현 객체 생성, 연결하는 책임 가진 별도의 설정 클래스

    /* 생성자 주입 */
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        //return null;
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }


}
