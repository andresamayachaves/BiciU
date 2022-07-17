package co.com.biciu.Entities;

import co.com.biciu.Enums.UserType;

public class User {
    private UserType userType = UserType.S;
    private int DNI = 0;
    private String name = "";
    private int age = 0;
    private double debt = 0.0;

    public User(UserType userType, int ID, String name, int age, double debt) {
        this.userType = userType;
        this.DNI = DNI;
        this.name = name;
        this.age = age;
        this.debt = debt;
    }
}
