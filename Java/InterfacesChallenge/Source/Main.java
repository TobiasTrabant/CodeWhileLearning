package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Object> savedValues;


    public static void main(String[] args) {

        savedValues = new ArrayList<>();

        Player tobi = new Player();

        restoreValues(tobi);

        saveValues(tobi);

        for(int i = 0 ; i < savedValues.size(); i++){
            System.out.println("Saved " + savedValues.get(i).toString());
        }

    }

    private static void saveValues(ISaveable objectToSave){
        for(int i = 0; i < objectToSave.returnValues().size(); i++){
            String value = objectToSave.returnValues().get(i).toString();
            System.out.println("Saved " + value + " from Player: " );
            savedValues.add(value);
        }
    }

    private static void restoreValues(Player player){
        player.populateField(readValues());
    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        int action= 0;
        System.out.println("0 - Quit" +
                            "1 - Enter string");

        while(!quit){
            System.out.println("Choose an option");
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter string : ");
                    values.add(index,scanner.nextLine());
                    index++;
                    break;
            }
        }
        return values;
    }
}
