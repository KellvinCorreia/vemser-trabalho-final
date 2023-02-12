package src.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID uuid = UUID.randomUUID();
    private Client client;
    private List<Product> products = new ArrayList<>();


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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void setProducts(Product product) {
        this.products.add(product);
    }
    public List<Product> getProducts() {
        return products;
    }
    public void updateProduct(Product oldProduct, Product newProduct) {
        int index = products.indexOf(oldProduct);
        products.set(index, newProduct);
    }
    public void deleteProduct(Product product) {
        if (this.products.contains(product)) {
            this.products.remove(product);
        } else {
            System.out.println("O produto não foi encontrado no estoque.");
        }
    }

    public Order() {

    }
    public Order(Client client, int paymentType) {
        this.client = client;
        this.paymentType = paymentType;
    }

    public double totalPrice() {
        return getProducts().stream()
                .mapToDouble(element -> element.getPrice())
                .sum();
    }
}