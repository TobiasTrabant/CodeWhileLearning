package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    static MobilePhone phone = new MobilePhone("29515");

    public static void main(String[] args) {


        boolean quit = false;

        printActions();
        while(!quit) {
            System.out.println("Enter Action: 6 to show available actions");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Shutting down");
                    quit = true;
                    break;
                case 1:
                    phone.printContacts();
                    break;
                case 2:
                    createContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Invalid action entered");
                    break;
            }
        }

    }
    private static void printActions() {
        System.out.println("0 - Quit.\n" +
                           "1 - Print Contacts\n" +
                            "2 - Create new Contact\n" +
                            "3 - Update Contact\n" +
                            "4 - Remove Contact\n" +
                            "5 - Find Contact\n" +
                            "6 - Print Actions");
    }

    private static void createContact(){
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String number = scanner.nextLine();
        if(phone.createContact(name,number)) {
            System.out.println("Contact successfully created.");
        }else {
            System.out.println("Could not create contact. Contact already exists");
        }
    }

    private static void updateContact(){
        System.out.println("Enter Contact to update: ");
        String nameOld = scanner.nextLine();
        if(phone.findContact(nameOld) == null) {
            System.out.println("Contact not found.");
        }else {
            System.out.println("Enter new contact name: ");
            String name = scanner.nextLine();
            System.out.println("Enter new contact number: ");
            String number = scanner.nextLine();
            phone.findContact(nameOld).setName(name);
            phone.findContact(name).setPhoneNumber(number);
            System.out.println("Contact successfully updated");
        }
    }

    private static void findContact(){
        System.out.println("Enter name of contact: ");
        String name = scanner.nextLine();
        if(phone.findContact(name) != null) {
            System.out.println("Contact found: ");
            System.out.println(phone.findContact(name).getName() + "->" + phone.findContact(name).getPhoneNumber());
        }else {
            System.out.println("Contact not found");
        }
    }

    private static void removeContact(){
        System.out.println("Enter contact to remove");
        String name = scanner.nextLine();
        if(phone.removeContact(name)){
            System.out.println("Remove successful");
        }else {
            System.out.println("Contact not found");
        }
    }
}
