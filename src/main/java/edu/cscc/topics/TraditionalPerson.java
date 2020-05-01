package edu.cscc.topics;

public class TraditionalPerson {
    private FluentPerson.Gender gender;
    private int age;
    private int height;

    public TraditionalPerson(FluentPerson.Gender gender, int age, int height) {
        this.gender = gender;
        this.age = age;
        this.height = height;
    }

    public TraditionalPerson(int age, int height) {
        this.age = age;
        this.height = height;
    }

    public TraditionalPerson(FluentPerson.Gender gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public void setGender(FluentPerson.Gender gender) {
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
}
