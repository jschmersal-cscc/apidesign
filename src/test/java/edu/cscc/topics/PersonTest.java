package edu.cscc.topics;

import org.junit.Test;

import static edu.cscc.topics.FluentPerson.Gender.*;

public class PersonTest {

    @Test
    public void fluentTest() {
        FluentPerson person = FluentPerson.newPerson(MALE).aged(10).height(60).build();
        System.out.println("Person: " + person);
    }

    @Test
    public void traditionalTest() {
        TraditionalPerson person = new TraditionalPerson(10, 60);
        person.setGender(MALE);
        System.out.println(person);
    }
}
