package com.emmanuelscode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Using class to declare player type
        Player emmanuel = new Player("Emmanuel", 10, 15);
        System.out.println(emmanuel.toString());
        saveObject(emmanuel);

        emmanuel.setHitPoints(8);
        System.out.println(emmanuel);
        emmanuel.setWeapon("Gunns");
        saveObject(emmanuel);
        loadObject(emmanuel);
        System.out.println(emmanuel);

        // Using Interface to declare monster variable
        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf.toString());
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        saveObject(werewolf);
    }

    public static List<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave){
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
            
        }
    }

    public static void loadObject(ISaveable objectToLoad){
        List <String> values = readValues();
        objectToLoad.read(values);
    }










}