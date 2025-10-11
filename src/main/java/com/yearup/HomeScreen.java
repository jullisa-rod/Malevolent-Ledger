package com.yearup;
import java.util.Scanner;

public class HomeScreen {
    public static void showHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while(running) {
            System.out.println("Welcome to Malevolent Ledger, where we handle your money like it's our own!");
            System.out.println("1. add a deposit?");
            System.out.println("2. Make a Payment");
            System.out.println("3. Access your ledger");
            System.out.println("4. Show how many movies");
            System.out.println("5. Exit");
            System.out.print("Pick here: ");
        }

    }

}
