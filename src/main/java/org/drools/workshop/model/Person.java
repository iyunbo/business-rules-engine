package org.drools.workshop.model;

/**
 * @author salaboy
 */
public class Person {

    public enum Employment {
        WhiteColor, Student, Unemployed
    }

    private String name;
    private int age;
    private String phoneNumber;
    private Boolean localResident;
    private Employment employment;

    public Person() {
    }

    public Person(String name, int age, String phoneNumber, Boolean localResident, Employment employment) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.localResident = localResident;
        this.employment = employment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getLocalResident() {
        return localResident;
    }

    public void setLocalResident(Boolean localResident) {
        this.localResident = localResident;
    }

    public Employment getEmployment() {
        return employment;
    }

    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", localResident=" + localResident + ", employment=" + employment + '}';
    }

}