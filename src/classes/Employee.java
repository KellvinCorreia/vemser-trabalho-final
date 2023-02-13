package src.classes;

import src.classes.abstracts.User;

import src.interfaces.Print;

import java.util.Calendar;
import java.util.UUID;

public class Employee extends User{
    private final UUID idRegistration;
    private double salary;
    private int monthlySales;

    public Employee(){
        super();
        this.idRegistration = UUID.randomUUID();
        this.monthlySales = 0;
    }

    public Employee(String CPF, String name, String email, int userType) {
        super(CPF, name, email, userType);
        this.idRegistration = UUID.randomUUID();
        this.monthlySales = 0;
    }

    public Employee(String CPF, String name, String email, Calendar birthDate, int userType) {
        super(CPF, name, email, birthDate, userType);
        this.idRegistration = UUID.randomUUID();
        this.monthlySales = 0;
    }

    public UUID getIdRegistration() {
        return idRegistration;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void giveCommission(double bonus) {
        this.setSalary(this.getSalary() + bonus);
    }

    public int getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales() {
        this.monthlySales++;
    }

    public void showInfos() {

        System.out.printf("""
                Matrícula: %s
                Nome: %s
                CPF: %s
                Email: %s
                Data de nascimento: %s
                Salário: R$ %.2f
                Vendas mensais: %d
                Tipo de usuário: %d
                """, this.getIdRegistration(), this.getName(), this.getCPF(), this.getEmail(), this.getFormatedBirthDate(), this.getSalary(), this.getMonthlySales(), this.getUserType());
    }
}
