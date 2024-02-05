// 클래스 설계 2: 각각의 객체를 생성, 계산 후 총 금액 출력

import java.math.BigDecimal;

public class Main2 {
    public static void main(String[] args) {
        // 상품 생성
        Product cosmetic = new Beauty("cosmetic", new BigDecimal(12000), 1.59);
        Product tv = new LargeAppliance("tv", new BigDecimal(35000), 10.0);
        Product grocery = new Grocery("grocery", new BigDecimal(10000), 0.3);

        // 배송비 계산
        DeliveryChargeCalculator calculator = new DefaultDeliveryChargeCalculator();
        BigDecimal BeautyDeliveryCharge = calculator.getDeliveryCharge(cosmetic.getWeight(), cosmetic.getPrice());
        System.out.println(cosmetic.getName() + " 배송비: " + BeautyDeliveryCharge);
        BigDecimal LargeApplianceDeliveryCharge = calculator.getDeliveryCharge(tv.getWeight(), tv.getPrice());
        System.out.println(tv.getName() + " 배송비: " + LargeApplianceDeliveryCharge);
        BigDecimal GroceryDeliveryCharge = calculator.getDeliveryCharge(grocery.getWeight(), grocery.getPrice());
        System.out.println(grocery.getName() + " 배송비: " + GroceryDeliveryCharge);

        // 총 배송비 계산(계산기 로직)
        BigDecimal totalDeliveryCharge;
        totalDeliveryCharge = GroceryDeliveryCharge.add(BeautyDeliveryCharge).add(LargeApplianceDeliveryCharge);

        totalDeliveryCharge = calculator.getDeliveryCharge(cosmetic.getWeight() + tv.getWeight() + grocery.getWeight(), cosmetic.getPrice().add(tv.getPrice()).add(grocery.getPrice()));

        System.out.println("총 금액: " + totalDeliveryCharge);
    }
}