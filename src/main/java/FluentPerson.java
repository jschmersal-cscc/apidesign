public class FluentPerson {

    private Gender gender;
    private int age;
    private int height;

    private FluentPerson() {
    }

    public enum Gender {
        FEMALE,
        MALE
    }
    public static InitialPersonBuilder newPerson(Gender gender) {
        return new Builder(gender);
    }


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
        return "FluentPerson{" +
                "gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
