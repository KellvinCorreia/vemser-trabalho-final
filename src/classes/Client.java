package src.classes;

import src.classes.abstracts.User;

import src.interfaces.Print;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Client extends User implements Print{
    private List<Address> address;
    private String phone;

    public Client() {
        super();
    }

    public Client(String CPF, String name, String email, int userType) {
        super(CPF, name, email, userType);
        this.address = new ArrayList<>();
    }

    public Client(String CPF, String name, String email, Calendar birthDate, int userType) {
        super(CPF, name, email, birthDate, userType);
        this.address = new ArrayList<>();
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address.add(address);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void showInfos() {

        System.out.printf("""
                Nome: %s
                CPF: %s
                Email: %s
                Data de nascimento: %s
                Telefone: %s
                Endereço: %s
                Tipo de usuário: %d
                """, this.getName(), this.getCPF(), this.getEmail(), this.getFormatedBirthDate(), this.getPhone(), this.getAddress(), this.getUserType());
    }
}
