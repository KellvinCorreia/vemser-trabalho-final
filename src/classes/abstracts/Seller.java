package src.classes.abstracts;

import src.classes.Address;
import src.classes.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class Seller {
    private String cnpj;
    private String name;
    private String email;
    protected int maxStockPerItem;
    protected int maxStock;
    private List<Address> address;
    protected List<Product> products = new ArrayList<>();


    public Seller(String cnpj, String name, String email, int maxStockPerItem, int maxStock) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.maxStockPerItem = maxStockPerItem;
        this.maxStock = maxStock;
    }

//    public String returnProducts(String str){
//        if (products.size() > 0){
//            System.out.println(str);
//            for (int i = 0; i < products.size(); i++) {
//                System.out.println(products.get(i).getName());
//            }
//        }
//        return null;
//    }

    public void returnDistinctList(String str){
        System.out.println(str);
        List<Product> listDistinct = products.stream().distinct().toList();
        for (Product product:listDistinct) {
            System.out.println(product.getName());
        }
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
            if (p.getName().contains(str)){
                if (!product.getName().equals("") && !product.getName().equals(null) && !product.getName().equals(p.getName())){
                    p.setName(product.getName());
                }
                if (!product.getDescription().equals("") && !product.getDescription().equals(null) && !product.getDescription().equals(p.getDescription())){
                    p.setDescription(product.getDescription());
                }
                if (product.getPrice() <= 0 && !product.getDescription().equals(p.getPrice())){
                    p.setPrice(product.getPrice());
                }
                return true;
            }
        }
        System.out.println("item não encontrado");
        return false;
    }
    public void addStock(Product product){
        products.add(product);
    }
    public void removeStock(Product product){
        products.remove(product);
    }

    public void changeCnpj(String str){
        if (!str.equals(getCnpj())){
            setCnpj(str);
        }
    }

    public void changeName(String str){
        if (!str.equals(getName())){
            setName(str);
        }
    }

    public void changeEmail(String str){
        if (!str.equals(getEmail())){
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
