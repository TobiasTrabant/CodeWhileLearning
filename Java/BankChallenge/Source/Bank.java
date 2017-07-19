package com.company;

import java.util.ArrayList;

/**
 * Created by Tobias on 30.05.2017.
 */
public class Bank {

    ArrayList<Branch> branches = new ArrayList<Branch>();

    public boolean addBranch(String name){
        if(findBranch(name)){
            System.out.println("Branch already exists.");
            return false;
        }else {
            branches.add(new Branch(name));
            System.out.println("Branch with the name: " + name + " successfully added");
            return true;
        }
    }

    public boolean findBranch(String name){
        for(int i = 0 ; i < branches.size(); i++){
            if(branches.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean addCustomer(String customerName, double initialAmount , String branchName){
        for(int i = 0 ; i < branches.size(); i++){
            if(branches.get(i).getName().equals(branchName)){
                branches.get(i).addCustomer(customerName,initialAmount);
                System.out.println("Customer " + customerName + " successfully added to " + branchName + "with initial amount of " + initialAmount);
                return true;
            }
        }
        return false;
    }

    public boolean addTransaction(String customerName, double amount, String branchName){
        for(int i = 0 ; i < branches.size(); i++){
            if(branches.get(i).getName().equals(branchName)){
                branches.get(i).getCustomer(customerName).addTransaction(amount);
                System.out.println("Transaction of " + amount + " added to Customer " + customerName + " at Branch " + branchName);
                return true;
            }
        }
        return false;
    }

    public void listCustomers(String branchName){
        for(int i = 0; i < branches.size(); i++) {
            if(branches.get(i).getName().equals(branchName)){
                branches.get(i).listCustomers();
            }
        }
    }

    public void listBranches(){
        for(int i = 0 ; i < branches.size(); i++){
            System.out.println(branches.get(i).getName());
        }
    }
}
