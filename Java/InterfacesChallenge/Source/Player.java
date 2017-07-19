package com.company;

import java.util.ArrayList;

/**
 * Created by Tobias on 01.06.2017.
 */
public class Player implements ISaveable {
    private String name = "tobi";
    private ArrayList<String> weapons;

    public Player() {
        this.weapons = new ArrayList<String>();
    }

    @Override
    public ArrayList returnValues() {
        return weapons;
    }

    @Override
    public void populateField(ArrayList list) {
       for(int i = 0 ; i < list.size(); i++){
           weapons.add(i,list.get(i).toString());
       }
    }

    public String getName() {
        return name;
    }
}
