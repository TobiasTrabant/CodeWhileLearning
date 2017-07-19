package com.company;

/**
 * Created by Tobias on 23.05.2017.
 */
public class Vehicle {

    private String color;
    private int tires;
    private String location;
    private int weight;
    private int direction;
    private int velocity;

    public Vehicle(String color, int tires, String location, int weight) {
        this.color = color;
        this.tires = tires;
        this.location = location;
        this.weight = weight;

        this.direction = 0;
        this.velocity = 0;
    }

    public void move (int speed, int direction) {
        this.velocity = speed;
        this.direction = direction;
        System.out.println("The Vehicle.move was called: Moving at " + velocity + "in direction" + direction);
    }

    public String getColor() {
        return color;
    }

    public int getTires() {
        return tires;
    }

    public String getLocation() {
        return location;
    }

    public int getWeight() {
        return weight;
    }

    public void steer(int direction){
        this.direction += direction;
        System.out.println("Vehicle.steer(): steering at " + direction + " deg");
    }

    public int getDirection() {
        return direction;
    }

    public int getVelocity() {

        return velocity;
    }

    public void stop () {
        velocity = 0;

    }
}
