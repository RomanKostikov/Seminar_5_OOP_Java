package org.example.cw01.model;

public class Human extends User {
    private int age;
    private float salary;

    public Human(String name, boolean haveCredit, int balance, int age, float salary) {
        super(name, haveCredit, balance);
        this.age = age;
        this.salary = salary;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
