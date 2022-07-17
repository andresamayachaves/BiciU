package co.com.biciu.Entities;

public class User {
    String UserType = new String();
    int DNI = 0;
    String name = new String();
    int age = 0;
    double debt = 0.0;

    public User(String userType, int ID, String name, int age, double debt) {
        UserType = userType;
        this.DNI = DNI;
        this.name = name;
        this.age = age;
        this.debt = debt;
    }
}
