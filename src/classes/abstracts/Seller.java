package src.classes.abstracts;

import src.classes.Address;
import src.classes.Product;
import src.interfaces.Dashboard;
import src.interfaces.Print;

import java.util.ArrayList;
import java.util.List;

public abstract class Seller implements Print, Dashboard {
    protected String cnpj;
    protected String name;
    protected String email;
    protected int maxStockPerItem;
    protected int maxStock;
    protected List<Address> address;
    protected List<Product> products = new ArrayList<>();


    public Seller(String cnpj, String name, String email, int maxStockPerItem, int maxStock) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.maxStockPerItem = maxStockPerItem;
        this.maxStock = maxStock;
    }

    public int returnNumProductsInStock(String value){
        int inStock = 0;
        for (Product product:products) {
            if (product.getName().contains(value)){
                inStock++;
            }
        }
        return inStock;
    }

    public boolean editProducts(String str, Product product){
        for (Product p:products) {
            if (p.getName().equals(str)){
                if (!product.getName().equals("") && !product.getName().equals(null) && !product.getName().equals(p.getName())){
                    p.setName(product.getName());
                }
                if (!product.getDescription().equals("") && !product.getDescription().equals(null) && !product.getDescription().equals(p.getDescription())){
                    p.setDescription(product.getDescription());
                }
                if (product.getPrice() >= 0 && product.getPrice() != p.getPrice()){
                    p.setPrice(product.getPrice());
                }
                return true;
            }
        }
        System.out.println("item não encontrado");
        return false;
    }

    @Override
    public void showStock() {
        List<Product> distinct = products.stream().distinct().toList();
        for (Product p:distinct) {
            System.out.printf("nome: %s, descição: %s, preço: %.2f e quantidade em estoque: %d",
                    p.getName(),
                    p.getDescription(),
                    p.getPrice(),
                    returnNumProductsInStock(p.getName()));
            System.out.println();
        }
    }

    @Override
    public void lackProducts() {
        double percentage = (products.size() * 100) / maxStock;
        System.out.println("quantidade de produtos: " + products.size());
        System.out.println("o estoque está " + percentage + "% cheio");
        if (percentage < 20){
            System.out.println("precisa estocar mais produtos");
        }
    }

    @Override
    public void showInfos() {
        System.out.printf("CNPJ: %s, nome: %s, email: %s", cnpj, name, email);
        System.out.println();
    }

    public void addStock(Product product){
        products.add(product);
    }
    public void removeStock(Product product){
        products.remove(product);
    }

    public void changeCnpj(String str){
        if (!str.equals(getCnpj()) && str != ""){
            setCnpj(str);
        }
    }

    public void changeName(String str){
        if (!str.equals(getName()) && str != ""){
            setName(str);
        }
    }

    public void changeEmail(String str){
        if (!str.equals(getEmail()) && str != ""){
            setEmail(str);
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address.add(address);
    }
}
