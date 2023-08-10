package kyul.springbasic.core.order;

import kyul.springbasic.core.AppConfig;
import kyul.springbasic.core.member.Grade;
import kyul.springbasic.core.member.Member;
import kyul.springbasic.core.member.MemberService;
import kyul.springbasic.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

/*
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
*/

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
