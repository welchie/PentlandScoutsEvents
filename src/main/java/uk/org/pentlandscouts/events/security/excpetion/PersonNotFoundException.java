package uk.org.pentlandscouts.events.security.excpetion;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String errorMsg)
    {
        super(errorMsg);
    }
}
