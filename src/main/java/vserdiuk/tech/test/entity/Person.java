package vserdiuk.tech.test.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by vserdiuk on 7/26/18
 */

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Long personalIdNumber;
    private Address address;

    public Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthday = builder.birthday;
        this.personalIdNumber = builder.personalIdNumber;
        this.address = builder.address;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Long getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(Long personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(personalIdNumber, that.personalIdNumber) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, birthday, personalIdNumber, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", personalIdNumber=" + personalIdNumber +
                ", address=" + address +
                '}';
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private LocalDate birthday;
        private Long personalIdNumber;
        private Address address;

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public PersonBuilder setPersonalIdNumber(Long personalIdNumber) {
            this.personalIdNumber = personalIdNumber;
            return this;
        }

        public PersonBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
