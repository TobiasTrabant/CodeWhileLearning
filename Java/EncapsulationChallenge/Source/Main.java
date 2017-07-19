package com.company;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(50,true);

        System.out.println(printer.addToner(25));
        System.out.println(printer.printing(100));
        System.out.println(printer.printing(150));
        System.out.println(printer.getPagesPrinted());





    }
}
