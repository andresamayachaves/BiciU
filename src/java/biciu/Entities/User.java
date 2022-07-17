package java.biciu.Entities;

import java.biciu.Enums.UserType;

public class User {
    private UserType userType;
    private String ID;
    private String name;
    private int age;
    private double debt;

    public User() {
        this.userType = UserType.S;
        this.ID = "";
        this.name = "";
        this.age = 0;
        this.debt =0;
    }

    public User(UserType userType, String ID, String name, int age, double debt) {
        this.userType = userType;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.debt = debt;
    }

    public void printUserInfo(){
        System.out.println("ID: "+this.ID);
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
    }
    public String  getID() {return this.ID;}

    public boolean userHasDebt(){
            return this.debt !=0;
    }
}