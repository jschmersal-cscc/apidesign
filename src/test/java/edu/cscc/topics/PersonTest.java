package edu.cscc.topics;

import org.junit.Test;

import static edu.cscc.topics.FluentPerson.female;
import static edu.cscc.topics.FluentPerson.newPerson;
import static edu.cscc.topics.Person.Gender.FEMALE;
import static edu.cscc.topics.Person.Gender.MALE;
import static org.junit.Assert.*;


public class PersonTest {


    @Test
    public void traditionalTest() {
        TraditionalPerson person = new TraditionalPerson(MALE,10, 60);
        System.out.println("Person: " + person);
        assertNotNull(person.getGender());

    }

    @Test
    public void fluentTest() {
        Person person = newPerson(MALE).aged(10).height(60).build();
        System.out.println("Person: " + person);
        assertNotNull(person.getGender());
    }

    @Test
    public void fluentInterfaceForcesConsistentState() {
        // Uncomment this line.  Note that you simply can't create a new FluentPerson()
        // Person person = new FluentPerson();

        // OK, what if I don't do the full initialization?  Maybe I can get an object with inconsistent state?  Uncomment this
        //Person person = FluentPerson.newPerson(FEMALE);

        // The only way to actually get a Person from this style is to fully create it using the builders as enforced by the API
        Person person = newPerson(FEMALE).aged(10).height(48).build();

        // This interface style simply guarantees that it's impossible to get a person without a gender, so the following
        // test is kind of useless.
        assertNotNull(person.getGender());
    }

    @Test
    public void traditionalObjectAllowsInconsistentState() {
        Person person = new TraditionalPerson();
        assertNotNull(person.getGender());
        assertNotNull(person.getHeight());
    }

    @Test
    public void whichIsMoreReadable() {
        // as a maintainer, which would you prefer to read?
        TraditionalPerson personA = new TraditionalPerson(48,10);
        personA.setGender(FEMALE);

        // or:
        Person personB = newPerson(FEMALE).aged(10).height(48).build();

        // or:
        Person personC = female().aged(10).height(48).build();
    }

    @Test
    public void thisIsConfusing() {
        // with all these constructors, it's easy to get the order wrong
        TraditionalPerson personA = new TraditionalPerson(FEMALE, 10,48);

        TraditionalPerson personB = new TraditionalPerson(10,48);
        personB.setGender(FEMALE);

        assertEquals(personA.getAge(), personB.getAge());

    }
}
