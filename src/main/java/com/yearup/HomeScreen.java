package com.yearup;
import java.util.Scanner;

public class HomeScreen {
    public static void showHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

//        The home screen should give the user the following options. The
//        application should continue to run until the user chooses to exit.
//§ D) Add Deposit - prompt user for the deposit information and
//        save it to the csv file
//§ P) Make Payment (Debit) - prompt user for the debit
//        information and save it to the csv file
//§ L) Ledger - display the ledger screen
//§ X) Exit - exit the application

        while (running) {
            System.out.println("Welcome to Malevolent Ledger, where we handle your money like it's our own!");
            System.out.println("d. add a deposit?");
            System.out.println("p. Make a Payment");
            System.out.println("l. Access your ledger");
            System.out.println("x. Exit");
            System.out.print("Pick here: ");
            //User should input their data (scanner)
            String choice = scanner.nextLine();

            //switch - better but can use if statements


            switch (choice) {
                case "d" -> System.out.println("add a deposit");
                case "p" -> System.out.println("make a payment");
                case "l" -> System.out.println("access your ledger");
                case "x" -> System.out.println("exit");

                default -> System.out.println("Invalid choice, try again!");
            }

        }

    }
}
