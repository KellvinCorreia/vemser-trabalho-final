package src.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID uuid = UUID.randomUUID();
    private Client client;
    private List<Product> products = new ArrayList<>();

    public Order() {

    }
    public Order(Client client, int paymentType) {
        this.client = client;
        this.paymentType = paymentType;
    }

    private int paymentType;
    private boolean status;

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        this.products.add(product);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double totalPrice() {
        return getProducts().stream()
                .mapToDouble(element -> element.getPrice())
                .sum();
    }
}