package kyul.springbasic.core;

import kyul.springbasic.core.member.Grade;
import kyul.springbasic.core.member.Member;
import kyul.springbasic.core.member.MemberService;
import kyul.springbasic.core.member.MemberServiceImpl;
import kyul.springbasic.core.order.Order;
import kyul.springbasic.core.order.OrderService;
import kyul.springbasic.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        //MemberService memberService = new MemberServiceImpl();
        //OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        //System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
