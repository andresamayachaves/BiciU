package main.java.biciU.Entities;

import main.java.biciU.Enums.UserType;

public class User {
    private UserType userType;
    private String ID;
    private String name;
    private int age;
    private double debt;
    private Ticket UserTickets[] ;
    private boolean blocked;

    public User() {
        this.userType = UserType.S;
        this.ID = "";
        this.name = "";
        this.age = 0;
        this.debt =0;
        this.blocked = false;
    }

    public User(UserType userType, String ID, String name, int age, double debt, boolean blocked) {
        this.userType = userType;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.debt = debt;
        this.blocked = blocked;
    }

    public void sumDebt(double addDebt) {
        this.debt = this.debt + addDebt;
    }

    public void reduceDebt(double reduceDebt) {
        this.debt = this.debt - reduceDebt;
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

    public void blockUser(){
        this.blocked=true;
    }

    public void unBlockUser(){
        this.blocked=false;
    }
}