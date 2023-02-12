package src;

import src.classes.Address;
import src.classes.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//       Create Client User
        int userType = 2;

        System.out.print("Informe o CPF: ");
        String CPF = scanner.nextLine();

        System.out.print("Informe o nome: ");
        String name = scanner.nextLine();

        System.out.print("Informe o email: ");
        String email = scanner.nextLine();

        System.out.print("Informe a data de nascimento: \n");
        System.out.print("Digite o dia de nascimento: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o mês de nascimento: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o ano de nascimento: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o valor de pagamento: ");
        double money = scanner.nextDouble();
        scanner.nextLine();


        Client client = new Client(CPF, name, email, money, userType);
        client.setBirthDate(day, month, year);

        System.out.print("Informe o telefone: ");
        client.setPhone(scanner.nextLine());

        System.out.print("Informe o endereço: \n");
        System.out.print("Digite o CEP: ");
        String CEP = scanner.nextLine();

        System.out.print("Digite a rua: ");
        String street = scanner.nextLine();

        System.out.print("Digite o número: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o complemento: ");
        String complement = scanner.nextLine();

        System.out.print("Digite o bairro: ");
        String neighborhood = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        String city = scanner.nextLine();

        System.out.print("Digite o estado: ");
        String state = scanner.nextLine();

        System.out.print("Digite o país: ");
        String country = scanner.nextLine();

        client.setAddress(new Address(CEP, street, number, complement, neighborhood, city, state, country));

    }
}
