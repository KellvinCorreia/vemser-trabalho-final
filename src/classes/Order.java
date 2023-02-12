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

    public boolean getProductInStore(Store store, String productName, int qtd){
        Product product = store.getProducts().stream().filter(product1 -> product1.getName().equals(productName)).findFirst().get();
        if (product != null){
            if (qtd < store.returnNumProductsInStock(productName)){
                for (int i = 0; i <qtd; i++) {
                    products.add(product);
                }
            }
            System.out.println("produtos postos no carrinho");
            return true;
        }
        System.out.println("produtos em estoque menor que o pedido");
        return false;
    }


    public boolean checkout(Store store){
        if (client.getMoney() >= totalPrice()){
            client.setMoney(client.getMoney() - totalPrice());
            removeStockStore(store);
            products.clear();
            status = true;
            System.out.println("compra finalizada");
            return true;
        }
        System.out.println("saldo insuficiente");
        return false;
    }

    public void showItems(){
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("id[%d], nome: %s", (i + 1), products.get(i).getName());
        }
    }

    public void removeStockStore(Store store){
        for (Product p:products) {
            store.removeStock(p);
        }
    }

}