import java.math.BigDecimal;

// 배송비 계산 인터페이스
public interface DeliveryChargeCalculator {
	BigDecimal getDeliveryCharge(Double weight, BigDecimal price);
}

//배송비 계산 구현체
class DefaultDeliveryChargeCalculator implements DeliveryChargeCalculator {
	@Override
	public BigDecimal getDeliveryCharge(Double weight, BigDecimal price) {
		BigDecimal weightDecimal = BigDecimal.valueOf(weight);
		BigDecimal priceDecimal = price;

		BigDecimal baseCharge;
		// 3키로 미만이면 배송비 1천원
		if (weightDecimal.compareTo(new BigDecimal(3)) < 0) {
			baseCharge = new BigDecimal(1000);
		// 3키로 이상 10키로 미만이면 배송비 5천원
		} else if (weightDecimal.compareTo(new BigDecimal(10)) < 0) {
			baseCharge = new BigDecimal(5000);
		// 10키로 이상이면 배송비 1만원
		} else {
			baseCharge = new BigDecimal(10000);
		}

		// 가격이 3만원 이상 10민원 미만이면 배송비 천원 할인
		if (priceDecimal.compareTo(new BigDecimal(30000)) >= 0 && priceDecimal.compareTo(new BigDecimal(100000)) < 0) {
			return baseCharge.subtract(new BigDecimal(1000));
		// 가격이 10만원 이상이면 배송비 무료
		} else if (priceDecimal.compareTo(new BigDecimal(100000)) >= 0) {
			return BigDecimal.ZERO;
		// 가격이 3만원 미만이면 무게단위 배송비 적용
		} else {
			return baseCharge;
		}
	}
}
