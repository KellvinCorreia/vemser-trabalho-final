package src.classes;

import src.classes.abstracts.Seller;

public class Store extends Seller {
    public Store(String cnpj, String name, String email, int maxStockPerItem, int maxStock) {
        super(cnpj, name, email, maxStockPerItem, maxStock);
    }

    public boolean reStock(Supplier supplier, String nameProduct, int qtd){
        Product product = supplier.getProducts().stream().filter(product1 -> product1.getName().equals(nameProduct)).findFirst().get();
        if(product != null){
            if (qtd < supplier.returnNumProductsInStock(nameProduct) && (qtd + returnNumProductsInStock(nameProduct)) <= maxStockPerItem && (qtd + products.size()) <= maxStock){
                for (int i = 0; i < qtd; i++) {
                    supplier.removeStock(product);
                    addStock(product);
                }
                System.out.println("estoque reposto");
                return true;
            }
            System.out.println("não temos em estoque a quantidade requerida");
            return false;
        }
        System.out.println("AA");
        return false;
    }
}
