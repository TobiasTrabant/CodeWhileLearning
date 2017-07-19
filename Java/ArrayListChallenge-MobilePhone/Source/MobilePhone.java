package com.company;

import java.util.ArrayList;

import static com.company.Main.scanner;

/**
 * Created by Tobias on 25.05.2017.
 */
public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> contacts;

    public MobilePhone(String number) {

        this.myNumber = number;
        this.contacts = new ArrayList<Contact>();
    }

    public String getMyNumber() {

        return myNumber;
    }

    public ArrayList<Contact> getContacts() {

        return contacts;
    }

    public void printContacts() {
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println("Name: " + contacts.get(i).getName() + " Phone: " + contacts.get(i).getPhoneNumber());
        }
    }

    public boolean createContact(String name, String number){
        if (findContact(name) != null) {
            return false;
        }else {
            contacts.add(Contact.createContact(name,number));
            return true;
        }
    }

    public Contact findContact(String name){
        for (int i = 0 ; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return contacts.get(i);
            }else {
                return null;
            }
        }
        return null;
    }

    public boolean removeContact(String name){
        if (findContact(name) == null){
            return false;
        }else {
            contacts.remove(findContact(name));
            return true;
        }
    }
}
