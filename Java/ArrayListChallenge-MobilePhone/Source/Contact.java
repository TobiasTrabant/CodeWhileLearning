package com.company;

/**
 * Created by Tobias on 25.05.2017.
 */
public class Contact {

    private String name;
    private String phoneNumber;


    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {

        return name;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Contact createContact(String name, String phone) {
        return new Contact(name,phone);
    }
}
