package com.company;

import java.util.ArrayList;

/**
 * Created by Tobias on 30.05.2017.
 */
public class Customer {

    private ArrayList<Double> transactions = new ArrayList<Double>();
    private String name;

    public Customer(String name, double initialAmount){
        this.name = name;
        this.transactions.add(initialAmount);
    }



    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
        System.out.println("Transaction of " + transaction + " successful");
    }


    public String getName() {
        return name;
    }
}
