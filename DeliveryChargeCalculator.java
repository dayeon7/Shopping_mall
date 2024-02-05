import java.math.BigDecimal;

// ��ۺ� ��� �������̽�
public interface DeliveryChargeCalculator {
	BigDecimal getDeliveryCharge(Double weight, BigDecimal price);
}

//��ۺ� ��� ����ü
class DefaultDeliveryChargeCalculator implements DeliveryChargeCalculator {
	@Override
	public BigDecimal getDeliveryCharge(Double weight, BigDecimal price) {
		BigDecimal weightDecimal = BigDecimal.valueOf(weight);
		BigDecimal priceDecimal = price;

		BigDecimal baseCharge;
		// 3Ű�� �̸��̸� ��ۺ� 1õ��
		if (weightDecimal.compareTo(new BigDecimal(3)) < 0) {
			baseCharge = new BigDecimal(1000);
		// 3Ű�� �̻� 10Ű�� �̸��̸� ��ۺ� 5õ��
		} else if (weightDecimal.compareTo(new BigDecimal(10)) < 0) {
			baseCharge = new BigDecimal(5000);
		// 10Ű�� �̻��̸� ��ۺ� 1����
		} else {
			baseCharge = new BigDecimal(10000);
		}

		// ������ 3���� �̻� 10�ο� �̸��̸� ��ۺ� õ�� ����
		if (priceDecimal.compareTo(new BigDecimal(30000)) >= 0 && priceDecimal.compareTo(new BigDecimal(100000)) < 0) {
			return baseCharge.subtract(new BigDecimal(1000));
		// ������ 10���� �̻��̸� ��ۺ� ����
		} else if (priceDecimal.compareTo(new BigDecimal(100000)) >= 0) {
			return BigDecimal.ZERO;
		// ������ 3���� �̸��̸� ���Դ��� ��ۺ� ����
		} else {
			return baseCharge;
		}
	}
}
