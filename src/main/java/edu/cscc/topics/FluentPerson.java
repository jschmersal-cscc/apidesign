package edu.cscc.topics;

public class FluentPerson implements Person {

    private Gender gender;
    private int age;
    private int height;

    // Make the default constructor private.  This means there's no way to new FluentPerson(...)
    // Which means we explicitly control creation of the FluentPerson objects.
    private FluentPerson() {
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

    // Frequently fluent interfaces will have a static method on the class to get you started.  Here's one:
    public static InitialPersonBuilder newPerson(Gender gender) {
        return new Builder(gender);
    }

    // Here's a couple more:
    public static InitialPersonBuilder female() { return new Builder(Gender.FEMALE); }
    public static InitialPersonBuilder male() { return new Builder(Gender.MALE); }


    // This is the guts.  You can ignore the implementation.  Just know that there's an internal builder class
    // that moves you through stages of creation by returning an interface with a limited set of
    // methods that can be called
    public static class Builder implements InitialPersonBuilder, PersonWithAge, PersonWithHeight {
        private FluentPerson person = new FluentPerson();

        private Builder(Gender gender) {
            person.gender = gender;
        }

        public PersonWithAge aged(int years) {
            person.age = years;
            return this;
        }

        public PersonWithHeight height(int inches) {
            person.height = inches;
            return this;
        }

        public FluentPerson build() {
            return person;
        }
    }

    public interface PersonWithAge {
        PersonWithHeight height(int inches);
    }

    public interface InitialPersonBuilder {
        PersonWithAge aged(int years);
    }

    public interface PersonWithHeight {
        FluentPerson build();
    }

    @Override
    public String toString() {
        return "edu.cscc.topics.FluentPerson{" +
                "gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
