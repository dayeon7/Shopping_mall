// 클래스 설계 1: 직접 입력

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("입력할 상품 개수를 입력하세요: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거

        BigDecimal totalDeliveryCharge = BigDecimal.ZERO;
        BigDecimal TotalPrice = BigDecimal.ZERO;
        Double TotalWeight = 0.0;

        for (int i = 1; i <= n; i++) {
            System.out.println("=== 상품 " + i + " 정보 입력 ===");

            System.out.print("상품 종류를 입력하세요.\n1: 화장품(Beauty), 2: 식료품(Grocery), 3(기타): 대형가전(LargeAppliance): ");
            String category = scanner.nextLine();
            
            System.out.print("이름 입력: ");
            String name = scanner.nextLine();

            System.out.print("무게 입력: ");
            Double weight = scanner.nextDouble();

            System.out.print("가격 입력: ");
            BigDecimal price = scanner.nextBigDecimal();

            // 배송비 계산
            Product p;
            
			if (category == "1") {
				p = new Beauty(name, price, weight);
			} else if (category == "2") {
				p = new Grocery(name, price, weight);
			} else {
				p = new LargeAppliance(name, price, weight);
			}
            DeliveryChargeCalculator calculator = new DefaultDeliveryChargeCalculator();
            BigDecimal deliveryCharge = calculator.getDeliveryCharge(p.getWeight(), p.getPrice());

            System.out.println(
                "> 상품 " + i + " 정보: " + p.getName() + " / " + p.getPrice() + "원 / "+ p.getWeight() + "kg\n" + "> 배송비: " + deliveryCharge
            );
            
            // 총 가격에 저장
            TotalPrice = TotalPrice.add(p.getPrice());
            System.out.println(">> 현재 가격: " + TotalPrice);
            // 총 무게에 저장
            TotalWeight += p.getWeight();
            
            // 배송비 총합에 추가
//            totalDeliveryCharge = totalDeliveryCharge.add(deliveryCharge);
        
            scanner.nextLine(); // 개행 문자 제거
        }
        
        DeliveryChargeCalculator calculator = new DefaultDeliveryChargeCalculator();
        totalDeliveryCharge = calculator.getDeliveryCharge(TotalWeight, TotalPrice);

        System.out.println(">> 총 가격: " + TotalPrice);
        System.out.println(">> 총 무게: " + TotalWeight);
        System.out.println(">> 총 배송비: " + totalDeliveryCharge);
        scanner.close();
    }
}