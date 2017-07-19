package com.company;

public class Main {

    public static void main(String[] args) {
        Porsche porsche = new Porsche("red","garage",500,"911",240);
        porsche.steer(20);
        porsche.accelerate(30);
        porsche.accelerate(20);
        porsche.accelerate(-42);
        porsche.accelerate(-8);

    }
}
