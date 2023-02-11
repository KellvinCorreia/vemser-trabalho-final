package src.classes.abstracts;

public abstract class User {
    private String CPF;
    private String name;
    private String email;
    private String birthDate;
    private int userType;

    public User(){}

    public User(String CPF, String name, String email, String birthDate, int userType) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
