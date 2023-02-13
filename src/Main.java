package src;

import src.classes.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Client> clients = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Supplier> suppliers = new ArrayList<>();
        initializingClassesForTest(clients, employees, suppliers);
        Store store = new Store("12. 345. 678/0001-99","Mercado do seu Zé","seuZe@gmail.com",25,300);

        String userInput = getUserInput(scanner);

        while (!userInput.equals("4")){
            switch (userInput){
//==============[Switch do APP]===========================
                case "1" ->{
                    System.out.println("entrou nas opções do usuário");
                    userInput = userOptions(scanner);
                    //==========[Switch do CLIENTE]=========
                    switch (userInput){
                        case "1" ->{
                            System.out.println("o que deseja cadastrar?");
                            userInput = getClientOrEmployeeInput(scanner);
                            switch (userInput){
                                case "1" ->{
                                    registerClient(scanner, clients);
                                }
                                case "2" ->{
                                    registerEmployee(scanner, employees);
                                }
                                default ->{
                                    System.out.println("input inválido");
                                }
                            }

                        }
                        case "2" ->{
                            System.out.println("CLIENTES:");
                            showListClients(clients);

                            System.out.println("FUNCIONÁRIOS");
                            showListEmployees(employees);
                        }
                        case "3" ->{
                            Client client = getClientInList(scanner, clients);
                            Order order = new Order(client);
                            while (!order.isStatus() && !userInput.equals("5")){
                                userInput = orderOptions(scanner);
                                //=======[Switch do ORDER]=========
                                switch (userInput){
                                    case "1" ->{//ADICIONAR ITEM NO CARRINHO
                                        putProductInCart(scanner, store, order);
                                    }
                                    case "2" ->{//MOSTRAR CARRINHO
                                        order.showItems();
                                        System.out.println("subtotal: " + order.totalPrice());
                                    }
                                    case "3" ->{//REMOVER ITEM DO CARRINHO
                                        removeProductFromCart(scanner, order);
                                    }
                                    case "4" ->{//Finalizar compra
                                        System.out.println("selecione o funcionario que lhe auxiliou");
                                        Employee employee = getEmployeeInList(scanner, employees);
                                        order.checkout(employee, store);
                                    }
                                    default ->{
                                        System.out.println("input inválido");
                                    }
                                }
                            }
                        }
                        case "4" ->{
                            System.out.println("escolha o que deseja editar:");
                            userInput = getClientOrEmployeeInput(scanner);
                            switch (userInput){
                                case "1" ->{
                                    editClient(scanner, clients);
                                }
                                case "2" ->{
                                    editEmployee(scanner, employees);
                                }
                            }
                        }
                        case "5" ->{
                            registerAddress(scanner, clients);
                        }
                        case "6" ->{
                            depositClient(scanner, clients);
                        }
                        default ->{
                            System.out.println("input inválido");
                        }
                    }
                }
                case "2" ->{
                    System.out.println("Entrou nas opções da loja:");
                    userInput = storeOptions(scanner);
                    //========[Switch da LOJA]=============
                    switch (userInput){
                        case "1" ->{
                            replacingStock(scanner, suppliers, store);
                        }
                        case "2" ->{
                            store.showStock();
                        }
                        case "3" ->{
                            store.showInfos();
                            store.lackProducts();
                        }
                        case "4" ->{
                            changeInfosStore(scanner, store);
                        }
                        case "5" ->{
                            editProductsOfStore(scanner, store);
                        }
                        default ->{
                            System.out.println("input inválido");
                        }
                    }
                }
                case "3" ->{
                    System.out.println("Entrou nas opções do fornecedor:");
                    userInput = supllierOptions(scanner);
                    //===========[Switch do FORNECEDOR]=============
                    switch (userInput){
                        case "1" ->{
                            addProductInStockSupllier(scanner, suppliers);
                        }
                        case "2" ->{

                            Supplier supplier = getSupplierinList(scanner, suppliers);
                            supplier.showStock();
                        }
                        case "3" ->{
                            Supplier supplier = getSupplierinList(scanner, suppliers);
                            supplier.showInfos();
                            supplier.lackProducts();
                        }
                        case "4" ->{
                            changeInfosSupllier(scanner, suppliers);
                        }
                        case "5" ->{
                            editProductsOfSupplier(scanner, suppliers);
                        }
                        case "6" ->{
                            addNewSupplier(scanner, suppliers);
                        }
                        default ->{
                            System.out.println("input inválido");
                        }
                    }
                }
                default -> {
                    System.out.println("input inválido");
                }
            }
            userInput = getUserInput(scanner);
        }

    }

    private static void depositClient(Scanner scanner, List<Client> clients) {
        Client client = getClientInList(scanner, clients);
        System.out.println("digite o valor do deposito");
        double value = scanner.nextDouble();
        scanner.nextLine();
        client.setMoney(value);
    }

    private static void registerAddress(Scanner scanner, List<Client> clients) {
        Client client = getClientInList(scanner, clients);
        System.out.println("Informe o endereço: ");
        System.out.println("Digite o CEP: ");
        String CEP = scanner.nextLine();

        System.out.println("Digite a rua: ");
        String street = scanner.nextLine();

        System.out.println("Digite o número: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o complemento: ");
        String complement = scanner.nextLine();

        System.out.println("Digite o bairro: ");
        String neighborhood = scanner.nextLine();

        System.out.println("Digite a cidade: ");
        String city = scanner.nextLine();

        System.out.println("Digite o estado: ");
        String state = scanner.nextLine();

        System.out.println("Digite o país: ");
        String country = scanner.nextLine();

        client.setAddress(new Address(CEP, street, number, complement, neighborhood, city, state, country));
    }

    private static void editEmployee(Scanner scanner, List<Employee> employees) {
        Employee employee = getEmployeeInList(scanner, employees);

        System.out.println("digite o novo cpf: ");
        String newCpf = scanner.nextLine();

        System.out.println("digite o novo nome: ");
        String newName = scanner.nextLine();

        System.out.println("digite o novo email: ");
        String newEmail = scanner.nextLine();

        System.out.println("digite a nova data de nascimento: ");
        int newDay = scanner.nextInt();
        scanner.nextLine();

        int newMonth = scanner.nextInt();
        scanner.nextLine();

        int newYear = scanner.nextInt();
        scanner.nextLine();

        employee.setCPF(newCpf);
        employee.setName(newName);
        employee.setEmail(newEmail);
        employee.setBirthDate(newDay, newMonth, newYear);
    }

    private static void editClient(Scanner scanner, List<Client> clients) {
        Client client = getClientInList(scanner, clients);
        System.out.println("digite o novo cpf: ");
        String newCpf = scanner.nextLine();

        System.out.println("digite o novo nome: ");
        String newName = scanner.nextLine();

        System.out.println("digite o novo email: ");
        String newEmail = scanner.nextLine();

        System.out.println("digite o novo telefone: ");
        String newPhone = scanner.nextLine();

        System.out.println("digite a nova data de nascimento: ");
        int newDay = scanner.nextInt();
        scanner.nextLine();

        int newMonth = scanner.nextInt();
        scanner.nextLine();

        int newYear = scanner.nextInt();
        scanner.nextLine();

        client.setCPF(newCpf);
        client.setName(newName);
        client.setEmail(newEmail);
        client.setPhone(newPhone);
        client.setBirthDate(newDay, newMonth, newYear);
    }

    private static void registerEmployee(Scanner scanner, List<Employee> employees) {
        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe o nome: ");
        String name = scanner.nextLine();

        System.out.print("Informe o email: ");
        String email = scanner.nextLine();

        System.out.print("Informe a data de nascimento: ");
        System.out.println("dia:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("mês:");
        int month = scanner.nextInt();
        scanner.nextLine();
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o valor do salário: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee employee = new Employee(cpf, name, email, 1);
        employee.setSalary(salary);
        employees.add(employee);
    }

    private static void registerClient(Scanner scanner, List<Client> clients) {
        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe o nome: ");
        String name = scanner.nextLine();

        System.out.print("Informe o email: ");
        String email = scanner.nextLine();

        System.out.println("Informe o telefone: ");
        String phone = scanner.nextLine();

        System.out.print("Informe a data de nascimento: ");
        System.out.println("dia:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("mês:");
        int month = scanner.nextInt();
        scanner.nextLine();
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o valor do saldo: ");
        double money = scanner.nextDouble();
        scanner.nextLine();

        Client client = new Client(cpf, name, email, phone, money, 2);
        client.setBirthDate(day, month, year);
        clients.add(client);
    }


    //============================[SUPPLIER METHODS]===========================================
    private static void addNewSupplier(Scanner scanner, List<Supplier> suppliers) {
        System.out.println("digite o CNPJ do fornecedor:");
        String cnpj = scanner.nextLine();

        System.out.println("digite o nome do fornecedor:");
        String name = scanner.nextLine();

        System.out.println("digite o email do fornecedor:");
        String email = scanner.nextLine();

        System.out.println("digite o máximo de estoque por item:");
        int maxStockPerItem = scanner.nextInt();
        scanner.nextLine();

        System.out.println("digite o máximo de estoque:");
        int maxStock = scanner.nextInt();
        scanner.nextLine();
        Supplier supplier = new Supplier(cnpj, name, email, maxStockPerItem, maxStock);
        suppliers.add(supplier);
    }

    private static void editProductsOfSupplier(Scanner scanner, List<Supplier> suppliers) {
        Supplier supplier = getSupplierinList(scanner, suppliers);
        supplier.showStock();

        System.out.println("digite o nome do produto que deseja editar as informações:");
        String productName = scanner.nextLine();

        Product newProduct = new Product();

        System.out.println("digite o novo nome do produto:");
        String newName = scanner.nextLine();
        newProduct.setName(newName);

        System.out.println("digite a nova descrição do produto:");
        String newDesc = scanner.nextLine();
        newProduct.setDescription(newDesc);

        System.out.println("digite o novo preço do produto:");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        newProduct.setPrice(newPrice);

        supplier.editProducts(productName,newProduct);
        supplier.showStock();
    }

    private static void changeInfosSupllier(Scanner scanner, List<Supplier> suppliers) {
        Supplier supplier = getSupplierinList(scanner, suppliers);

        System.out.println("digite o novo cnpj do fornecedor:");
        String novoCnpj = scanner.nextLine();
        supplier.changeCnpj(novoCnpj);

        System.out.println("digite o novo nome do fornecedor:");
        String novoNome = scanner.nextLine();
        supplier.changeName(novoNome);

        System.out.println("digite o novo email do fornecedor:");
        String novoEmail = scanner.nextLine();
        supplier.changeEmail(novoEmail);

        System.out.println("Informações:");
        supplier.showInfos();
    }
//=============================================================================================

    //============================[STORE METHODS]=================================================
    private static void addProductInStockSupllier(Scanner scanner, List<Supplier> suppliers) {
        Supplier supplier = getSupplierinList(scanner, suppliers);

        System.out.println("digite o nome do produto:");
        String name = scanner.nextLine();

        System.out.println("digite a descrição do produto:");
        String description = scanner.nextLine();

        System.out.println("digite o preço do produto:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("digite a quantidade:");
        int qtd = scanner.nextInt();
        scanner.nextLine();

        supplier.addProduct(name, description, price, qtd);
    }

    private static void editProductsOfStore(Scanner scanner, Store store) {
        store.showStock();

        System.out.println("digite o nome do produto que deseja editar as informações:");
        String productName = scanner.nextLine();

        Product newProduct = new Product();

        System.out.println("digite o novo nome do produto:");
        String newName = scanner.nextLine();
        newProduct.setName(newName);

        System.out.println("digite a nova descrição do produto:");
        String newDesc = scanner.nextLine();
        newProduct.setDescription(newDesc);

        System.out.println("digite o novo preço do produto:");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        newProduct.setPrice(newPrice);

        store.editProducts(productName,newProduct);
        store.showStock();
    }

    private static void changeInfosStore(Scanner scanner, Store store) {
        System.out.println("digite o novo cnpj da loja:");
        String novoCnpj = scanner.nextLine();
        store.changeCnpj(novoCnpj);

        System.out.println("digite o novo nome da loja:");
        String novoNome = scanner.nextLine();
        store.changeName(novoNome);

        System.out.println("digite o novo email da loja:");
        String novoEmail = scanner.nextLine();
        store.changeEmail(novoEmail);

        System.out.println("Informações:");
        store.showInfos();
    }

    private static void replacingStock(Scanner scanner, List<Supplier> suppliers, Store store) {
        Supplier supplier = getSupplierinList(scanner, suppliers);
        supplier.showStock();
        System.out.println("digite o nome do produto que deseja estocar:");
        String productName = scanner.nextLine();
        System.out.println("informe a quantidade:");
        int qtd = scanner.nextInt();
        scanner.nextLine();
        store.reStock(supplier, productName, qtd);
    }
//=======================================================================================================

//============================[ORDER METHODS]============================================================
    private static void removeProductFromCart(Scanner scanner, Order order) {
        order.showItems();
        System.out.println("digite o index do item que deseja remover");
        int index = scanner.nextInt();
        scanner.nextLine();
        order.deleteProduct(order.getProducts().get(index - 1));
    }

    private static void putProductInCart(Scanner scanner, Store store, Order order) {
        store.showStock();
        System.out.println("digite o nome do item que deseja comprar:");
        String productName = scanner.nextLine();
        System.out.println("informe a quantidade:");
        int qtd = scanner.nextInt();
        scanner.nextLine();
        order.getProductInStore(store, productName, qtd);
    }
//=========================================================================================================

//============================[ASSISTANTS METHODS]===============================
    public static Supplier getSupplierinList(Scanner scanner, List<Supplier> suppliers) {
        showListSuppliers(suppliers);
        System.out.println("escolha um fornecedor");
        int index = scanner.nextInt();
        scanner.nextLine();
        Supplier supplier = suppliers.get(index - 1);
        return supplier;
    }

    public static Client getClientInList(Scanner scanner, List<Client> clients){
        showListClients(clients);
        System.out.println("escolha um cliente");
        int index = scanner.nextInt();
        scanner.nextLine();
        Client client = clients.get(index - 1);
        return client;
    }

    public static Employee getEmployeeInList(Scanner scanner, List<Employee> employees){
        showListEmployees(employees);
        System.out.println("escolha um cliente");
        int index = scanner.nextInt();
        scanner.nextLine();
        Employee employee = employees.get(index - 1);
        return employee;
    }

    public static void initializingClassesForTest(List<Client> clientsList, List<Employee> employees, List<Supplier> suppliersList){
        Client client1 = new Client("123.547.352-55", "Maria", "mariazinha@gmail.com", "51 91234-5678", 50, 3);
        Employee employee = new Employee("321.654.879-64", "José", "jose@gmail.com", 1);

        Supplier supplier1 = new Supplier("45. 324. 894/0001-69", "Papelaria Genérica","papelaria@gmail.com",50,500);
        Supplier supplier2 = new Supplier("46. 185. 156/0001-61", "Papelaria Menos Genérica","papelariaMG@gmail.com",75,700);

        supplier1.addProduct("lápis", "lápis verde da BIC", 2.00, 20);
        supplier2.addProduct("borracha", "borracha branca", 1.5, 34);

        clientsList.add(client1);
        employees.add(employee);
        suppliersList.add(supplier1);
        suppliersList.add(supplier2);
    }
    public static String getUserInput(Scanner scanner){
        System.out.println();
        System.out.println("Informe a opção desejada:");

        System.out.println("1. opções do usuário");
        System.out.println("2. opções da loja");
        System.out.println("3. opções do fornecedor");
        System.out.println("4. sair");

        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String getClientOrEmployeeInput(Scanner scanner){
        System.out.println();
        System.out.println("o que deseja?");

        System.out.println("1. Cliente");
        System.out.println("2. Funcionário");

        String userInput = scanner.nextLine();
        return userInput;
    }
    public static String userOptions(Scanner scanner){
        System.out.println();
        System.out.println("o que deseja fazer?");

        System.out.println("1. cadastrar novo usuário");
        System.out.println("2. listar todos usuários");
        System.out.println("3. comprar");
        System.out.println("4. editar usuário");
        System.out.println("5. cadastrar endereço");
        System.out.println("6. depositar");

        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String orderOptions(Scanner scanner){
        System.out.println();
        System.out.println("o que deseja fazer?");

        System.out.println("1. botar item no carrinho");
        System.out.println("2. listar itens no carrinho");
        System.out.println("3. deletar itens do carrinho");
        System.out.println("4. pagar");
        System.out.println("5. sair");

        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String storeOptions(Scanner scanner){
        System.out.println();
        System.out.println("o que deseja fazer?");

        System.out.println("1. fazer pedido de estoque");
        System.out.println("2. mostrar estoque");
        System.out.println("3. mostrar informações da loja");
        System.out.println("4. editar informações da loja");
        System.out.println("5. editar informações dos produtos");

        String userInput = scanner.nextLine();
        return userInput;
    }

    public static String supllierOptions(Scanner scanner){
        System.out.println();
        System.out.println("o que deseja fazer?");

        System.out.println("1. adicionar estoque");
        System.out.println("2. mostrar estoque");
        System.out.println("3. mostrar informações do fornecedor");
        System.out.println("4. editar informações do fornecedor");
        System.out.println("5. editar informações dos produtos");
        System.out.println("6. adicionar novo fornecedor");

        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void showListSuppliers(List<Supplier> suppliers){
        for (int i = 0; i < suppliers.size(); i++) {
            System.out.println("id[" + (i + 1) + "], nome: " + suppliers.get(i).getName());
        }
    }
    public static void showListClients(List<Client> clients){
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("id[" + (i + 1) + "], nome:" + clients.get(i).getName() + ", saldo: " + clients.get(i).getMoney());
        }
    }
    public static void showListEmployees(List<Employee> employees){
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("id[" + (i + 1) + "], nome:" + employees.get(i).getName());
        }
    }
}
