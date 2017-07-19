package com.company;

/**
 * Created by Tobias on 23.05.2017.
 */
public class Porsche extends Car {

    private int speed;

    public Porsche(String color, String location, int weight, String model, int speed) {
        super(color, 4, location, weight, "Porsche", model);
        this.speed = speed;

    }

    public void accelerate(int rate) {

        int newVelocity = getVelocity() + rate;
        if(newVelocity == 0) {
            stop();
            System.out.println("new velocity 0");
        }else if(newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        }else{
            changeGear(2);
        }
        if(newVelocity >0) {
            changeVelocity(newVelocity, getDirection());
        }
    }

}
