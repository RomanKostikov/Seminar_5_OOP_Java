package org.example.cw01.model;

public class User {
    private String name;
    private boolean haveCredit;
    private int balance;

    public User(String name, boolean haveCredit, int balance) {
        this.name = name;
        this.balance = balance;
        this.haveCredit = false;
    }

    public User(String name) {
        this(name, false, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", haveCredit=" + haveCredit +
                ", balance=" + balance +
                '}';
    }

    public boolean isHaveCredit() {
        return haveCredit;
    }

    public void setHaveCredit(boolean haveCredit) {
        this.haveCredit = haveCredit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
