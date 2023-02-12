package src.classes;

import src.classes.abstracts.Seller;

public class Supplier extends Seller {

    public Supplier(String cnpj, String name, String email, int maxStockPerItem, int maxStock) {
        super(cnpj, name, email, maxStockPerItem, maxStock);
    }

    public void addProduct(String name, String description, Double price, int qtd){
        if((qtd + returnNumProductsInStock(name)) <= maxStockPerItem && (qtd + products.size()) <= maxStock){
            Product product = new Product(name, description, price, this);
            for (int i = 0; i < qtd; i++) {
                this.products.add(product);
            }
        }
        else {
            System.out.println("você excedeu o limite de estoque desse item ou estoque total");
        }
    }

}
