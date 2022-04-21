package inflearn.spring.core.order;

import inflearn.spring.core.discount.DiscountPolicy;
import inflearn.spring.core.discount.FixDiscountPolicy;
import inflearn.spring.core.member.Member;
import inflearn.spring.core.member.MemberRepository;
import inflearn.spring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
