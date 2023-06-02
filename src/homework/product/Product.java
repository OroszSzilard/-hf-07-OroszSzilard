package homework.product;

public class Product 
{
	protected String name;
	protected int price;
	public Product(String name, int price) {
		super();
		this.name = name;
		if(price>=0)
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price>=0)
		this.price = price;
	}
	public void decreasePrice(int percent)
	{
		price = price-(Math.round(((float)price/100)*percent));
	}
	
	public void increasePrice(int percenatge) {
		if(percenatge > 0) {
			price += Math.round(price*(float)percenatge/100);
		}		
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
