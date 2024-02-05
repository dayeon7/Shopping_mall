// Ŭ���� ���� 2: ������ ��ü�� ����, ��� �� �� �ݾ� ���

import java.math.BigDecimal;

public class Main2 {
    public static void main(String[] args) {
        // ��ǰ ����
        Product cosmetic = new Beauty("cosmetic", new BigDecimal(12000), 1.59);
        Product tv = new LargeAppliance("tv", new BigDecimal(35000), 10.0);
        Product grocery = new Grocery("grocery", new BigDecimal(10000), 0.3);

        // ��ۺ� ���
        DeliveryChargeCalculator calculator = new DefaultDeliveryChargeCalculator();
        BigDecimal BeautyDeliveryCharge = calculator.getDeliveryCharge(cosmetic.getWeight(), cosmetic.getPrice());
        System.out.println(cosmetic.getName() + " ��ۺ�: " + BeautyDeliveryCharge);
        BigDecimal LargeApplianceDeliveryCharge = calculator.getDeliveryCharge(tv.getWeight(), tv.getPrice());
        System.out.println(tv.getName() + " ��ۺ�: " + LargeApplianceDeliveryCharge);
        BigDecimal GroceryDeliveryCharge = calculator.getDeliveryCharge(grocery.getWeight(), grocery.getPrice());
        System.out.println(grocery.getName() + " ��ۺ�: " + GroceryDeliveryCharge);

        // �� ��ۺ� ���(���� ����)
        BigDecimal totalDeliveryCharge;
        totalDeliveryCharge = GroceryDeliveryCharge.add(BeautyDeliveryCharge).add(LargeApplianceDeliveryCharge);

        totalDeliveryCharge = calculator.getDeliveryCharge(cosmetic.getWeight() + tv.getWeight() + grocery.getWeight(), cosmetic.getPrice().add(tv.getPrice()).add(grocery.getPrice()));

        System.out.println("�� �ݾ�: " + totalDeliveryCharge);
    }
}