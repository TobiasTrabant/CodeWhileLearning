package com.company;

import java.util.Scanner;

public class Main {

    private static Bank myBank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        printActions();


        boolean quit = false;

        while(!quit){
            System.out.println("Enter action:");

            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    quit = true;
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    listCustomers();
                    break;
                case 5:
                    myBank.listBranches();
                    break;
                default:
                    break;
            }
        }

    }

    private static void printActions(){
        System.out.println("0 - Quit\n" +
                            "1 - Add branch\n" +
                            "2 - Add Customer\n" +
                            "3 - Add Transaction\n" +
                            "4 - List customers\n" +
                            "5 - List branches"
        );
    }

    private static void addBranch(){
        System.out.println("Type name");
        String name = scanner.nextLine();
        myBank.addBranch(name);
    }

    private static void addCustomer(){
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Branch: ");
        String branch = scanner.nextLine();
        myBank.addCustomer(name,amount,branch);
    }

    private static void addTransaction(){
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter Branch: ");
        String branch = scanner.nextLine();
        myBank.addTransaction(name,amount,branch);
    }

    private static void listCustomers(){
        System.out.println("Enter branch name");
        String name = scanner.nextLine();
        myBank.listCustomers(name);
    }
}
