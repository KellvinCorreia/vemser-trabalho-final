package src.classes.abstracts;

import src.interfaces.Print;

import java.util.Calendar;

public abstract class User implements Print {
    private String CPF;
    private String name;
    private String email;
    private Calendar birthDate;
    private int userType;

    public User(){}

    public User(String CPF, String name, String email, int userType) {
        this.CPF = CPF;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public User(String CPF, String name, String email, Calendar birthDate, int userType) {
        this.CPF = CPF;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.userType = userType;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public Calendar getBirthDate() {
        return birthDate;
    }

    public String getFormatedBirthDate() {

        if(this.getBirthDate() == null) {
            return "N/A";
        }

        int day = this.getBirthDate().get(Calendar.DAY_OF_MONTH);
        int month = this.getBirthDate().get(Calendar.MONTH) + 1;
        int year = this.getBirthDate().get(Calendar.YEAR);

        return day + "/" + month + "/" + year;
    }

    public void setBirthDate(int day, int month, int year) {
        this.birthDate = Calendar.getInstance();
        this.birthDate.set(Calendar.DAY_OF_MONTH, day);
        this.birthDate.set(Calendar.MONTH, month-1);
        this.birthDate.set(Calendar.YEAR, year);
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
