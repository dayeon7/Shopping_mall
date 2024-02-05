// Ŭ���� ���� 1: ���� �Է�

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("�Է��� ��ǰ ������ �Է��ϼ���: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // ���� ���� ����

        BigDecimal totalDeliveryCharge = BigDecimal.ZERO;
        BigDecimal TotalPrice = BigDecimal.ZERO;
        Double TotalWeight = 0.0;

        for (int i = 1; i <= n; i++) {
            System.out.println("=== ��ǰ " + i + " ���� �Է� ===");

            System.out.print("��ǰ ������ �Է��ϼ���.\n1: ȭ��ǰ(Beauty), 2: �ķ�ǰ(Grocery), 3(��Ÿ): ��������(LargeAppliance): ");
            String category = scanner.nextLine();
            
            System.out.print("�̸� �Է�: ");
            String name = scanner.nextLine();

            System.out.print("���� �Է�: ");
            Double weight = scanner.nextDouble();

            System.out.print("���� �Է�: ");
            BigDecimal price = scanner.nextBigDecimal();

            // ��ۺ� ���
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
                "> ��ǰ " + i + " ����: " + p.getName() + " / " + p.getPrice() + "�� / "+ p.getWeight() + "kg\n" + "> ��ۺ�: " + deliveryCharge
            );
            
            // �� ���ݿ� ����
            TotalPrice = TotalPrice.add(p.getPrice());
            System.out.println(">> ���� ����: " + TotalPrice);
            // �� ���Կ� ����
            TotalWeight += p.getWeight();
            
            // ��ۺ� ���տ� �߰�
//            totalDeliveryCharge = totalDeliveryCharge.add(deliveryCharge);
        
            scanner.nextLine(); // ���� ���� ����
        }
        
        DeliveryChargeCalculator calculator = new DefaultDeliveryChargeCalculator();
        totalDeliveryCharge = calculator.getDeliveryCharge(TotalWeight, TotalPrice);

        System.out.println(">> �� ����: " + TotalPrice);
        System.out.println(">> �� ����: " + TotalWeight);
        System.out.println(">> �� ��ۺ�: " + totalDeliveryCharge);
        scanner.close();
    }
}