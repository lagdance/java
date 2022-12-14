package com.emmanuelscode;

import java.util.ArrayList;
import java.util.List;

public class Gearbox {
    private List<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean cluthIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for (int i = 0; i < maxGears; i++) {
            addGear(i, i*5.3);
        }
    }

    public void operateClutch(boolean in){
        this.cluthIsIn = in;
    }

    public void addGear(int number, double ratio){
        if ((number > 0) && (number <= maxGears)){
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear (int newGear){
        if((newGear >= 0) && (newGear < this.gears.size()) && this.cluthIsIn){
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else{
            System.out.println("Grind!");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int rev){
        if(cluthIsIn){
            System.out.println("Scream!!");
            return 0.0;
        }
        return rev * gears.get(currentGear).getRatio();
    }

    // Inner Class - member of Gearbox
    private class Gear {

        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {

            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs){
            return revs * (this.ratio);
        }

        public double getRatio() {
            return ratio;
        }
    }




}
