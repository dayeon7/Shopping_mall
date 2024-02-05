import java.math.BigDecimal;

// ��ǰ Ŭ����
public class Product {
	private String name;
	private BigDecimal price;
	private Double weight;

	public Product(String name, BigDecimal price, Double weight) {
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}
}

// ȭ��ǰ Ŭ����
class Beauty extends Product {
    public Beauty(String name, BigDecimal price, Double weight) {
        super(name, price, weight);
    }
}

// �������� Ŭ����
class LargeAppliance extends Product {
	public LargeAppliance(String name, BigDecimal price, Double weight) {
		super(name, price, weight);
	}
}

// �ķ�ǰ Ŭ����
class Grocery extends Product {
	public Grocery(String name, BigDecimal price, Double weight) {
		super(name, price, weight);
	}
}