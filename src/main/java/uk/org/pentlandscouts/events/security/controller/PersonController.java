package uk.org.pentlandscouts.events.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.org.pentlandscouts.events.security.excpetion.PersonNotFoundException;
import uk.org.pentlandscouts.events.security.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")

public class PersonController {

    private final List<Person> personList = new ArrayList<Person>();

    public PersonController()
    {
        Person p = new Person("123456","Chris","Welch","30/03/1973");
        personList.add(p);
        p = new Person("987654321","Ross", "Nicol","27/11/1996");
        personList.add(p);
        p = new Person("666","Mr","Devil", "01/01/1666");
        personList.add(p);
    }

    @GetMapping("/{uid}")
    public Person getPerson(@PathVariable("uid") String uid) throws PersonNotFoundException
    {
        if (!uid.isEmpty()) {
            //return new Person(uid, "firstName", "lastName");

            List<Person> p = personList.stream().filter(c -> c.getUid().equals(uid)).collect(Collectors.toList());
            return p.get(0);
        }
        else
        {
            throw new PersonNotFoundException(uid);
        }
    }
}
