package kyul.springbasic.core.discount;

import kyul.springbasic.core.member.Member;

public interface DiscountPolicy {

    // Return 할인 대상 금액
    int discount(Member member, int price);
}
