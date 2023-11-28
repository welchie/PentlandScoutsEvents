package uk.org.pentlandscouts.events.security.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {

    private String uid = "";

    private String firstName = "";

    private String lastName = "";

    private String dob= "";

    public Person(String uid, String firstName, String lastName, String dob)
    {
        this.setUid(uid);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDob(dob);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(uid, person.uid) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, firstName, lastName, dob);
    }

    @Override
    public String toString() {
        return "Person{" +
                "uid='" + uid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastNAme='" + lastName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
