package uk.org.pentlandscouts.events.security.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.org.pentlandscouts.events.security.excpetion.PersonNotFoundException;
import uk.org.pentlandscouts.events.security.model.Person;

@RestController
@RequestMapping("/person")

public class PersonController {


    @GetMapping("/{uid}")
    public Person getPerson(@PathVariable("uid") String uid) throws PersonNotFoundException
    {
        if (!uid.isEmpty()) {
            return new Person(uid, "firstName", "lastName");
        }
        else
        {
            throw new PersonNotFoundException(uid);
        }
    }
}
