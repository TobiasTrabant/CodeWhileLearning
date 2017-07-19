package com.company;

public class Main {

    public static void main(String[] args) {

        NodeList list = new NodeList();
        String stringData = "Berlin Hamburg Aachen Oldenburg Karlsruhe";
        String[] data = stringData.split(" ");
        for(String a : data){
            Node newNode = new Node(a);
            list.addItem(newNode);
        }


        list.traverse();

        list.removeItem("Berlin");

        list.traverse();

    }
}
