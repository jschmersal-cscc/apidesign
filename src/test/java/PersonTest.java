import org.junit.Test;

public class PersonTest {

    @Test
    public void fluentTest() {
        FluentPerson person = FluentPerson.newPerson(FluentPerson.Gender.MALE).aged(10).height(60).build();
        System.out.println("Person: " + person);
    }

    @Test
    public void traditionalTest() {
        TraditionalPerson person = new TraditionalPerson(10, 60);
        person.setGender(FluentPerson.Gender.MALE);
        System.out.println(person);
    }
}
