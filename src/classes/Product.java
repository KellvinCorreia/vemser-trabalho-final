package src.classes;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private Supplier supplier;

    public Product(String name, String description, double price, Supplier supplier) {
        this.id = id++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.supplier = supplier;
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
