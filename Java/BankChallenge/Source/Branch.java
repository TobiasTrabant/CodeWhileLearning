package com.company;

import java.util.ArrayList;

/**
 * Created by Tobias on 30.05.2017.
 */
public class Branch {

    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private String name;


    public Branch(String name) {
        this.name = name;

    }

    public boolean addCustomer(String name, double initialAmount) {
        if(!findCustomer(name)){
            customers.add(new Customer(name,initialAmount));
            System.out.println("Customer " + name + " added with initial amount of: " + initialAmount);
            return true;
        }
        System.out.println("Customer with that name already exists.");
        return false;
    }

    private boolean findCustomer(String name){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer(String name) {
        for(int i = 0 ; i < customers.size(); i++){
            if(customers.get(i).getName().equals(name)){
                return customers.get(i);
            }
        }
        return null;
    }

    public void listCustomers(){
        for(int i = 0 ; i < customers.size(); i++){
            System.out.println(customers.get(i).getName());
        }
    }
}
