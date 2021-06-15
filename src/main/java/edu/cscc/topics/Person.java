package edu.cscc.topics;

public interface Person {
    int getHeight();
    int getAge();
    Gender getGender();

    public enum Gender {
        FEMALE,
        MALE,
        OTHER
    }
}
