package com.emmanuelscode;

public class Main {
    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
        hamburger.addHamburgerAddition1("Tomato", 0.27 );
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);
        hamburger.addHamburgerAddition4("Pickles", 0.30);

        System.out.println("Total Burger price is " + hamburger.itemizehamburger());
    }
}