package inflearn.spring.core.discount;

import inflearn.spring.core.member.Grade;
import inflearn.spring.core.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */

    int discount(Member member, int price);
}
