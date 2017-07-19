package com.company;

/**
 * Created by Tobias on 23.05.2017.
 */
public class Car extends Vehicle {

    private String brand;
    private String model;
    private int gears;

    private int currentGear;

    public Car(String color, int tires, String location, int weight, String brand, String model) {
        super(color, tires, location, weight);
        this.brand = brand;
        this.model = model;
        this.currentGear = 1;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getGears() {
        return gears;
    }

    public void changeGear(int gear) {
        this.currentGear = gear;
        System.out.println("Gear changed to " + gear);
    }

    public void changeVelocity (int speed, int direction) {
        move(speed,direction);
        System.out.println("Car changed velocity to " + speed);
    }
}
