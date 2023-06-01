package homework.product;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void decreasePrice(int percent) {
        double discount = price * (percent / 100.0);
        price -= discount;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price;
    }
}