package edu.cscc.topics;

public class TraditionalPerson implements Person {
    private Gender gender;
    private int age;
    private int height;

    // standard no-arg constructor
    public TraditionalPerson() {
        // nothing to do here
    }

    // typical usage pattern - have all fields defined ahead of time
    public TraditionalPerson(Gender gender, int age, int height) {
        this.gender = gender;
        this.age = age;
        this.height = height;
    }

    // Why can you create a person that doesn't have a Gender?  (from a programmer's standpoint
    public TraditionalPerson(int height, int age) {
        this.age = age;
        this.height = height;
    }

    // Why can you create a person that doesn't have a height?  (from a programmer's standpoint
    public TraditionalPerson(Gender gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    // Frequently we want "domain" objects to be read-only...
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "edu.cscc.topics.TraditionalPerson{" +
                "gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
