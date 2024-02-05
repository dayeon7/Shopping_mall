import java.math.BigDecimal;

// 상품 클래스
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

// 화장품 클래스
class Beauty extends Product {
    public Beauty(String name, BigDecimal price, Double weight) {
        super(name, price, weight);
    }
}

// 대형가전 클래스
class LargeAppliance extends Product {
	public LargeAppliance(String name, BigDecimal price, Double weight) {
		super(name, price, weight);
	}
}

// 식료품 클래스
class Grocery extends Product {
	public Grocery(String name, BigDecimal price, Double weight) {
		super(name, price, weight);
	}
}