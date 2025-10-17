package com.yearup;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static com.yearup.Start.simulateLoading;

public class HomeScreen {
    public void showHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

//        The home screen should give the user the following options. The
//        application should continue to run until the user chooses to exit.
//   D) Add Deposit - prompt user for the deposit information and
//        save it to the csv file
//   P) Make Payment (Debit) - prompt user for the debit
//        information and save it to the csv file
//   L) Ledger - display the ledger screen
//   X) Exit - exit the application
        System.out.println("Welcome to: ");
        System.out.println("""
                |\\/|  _. |  _      _  |  _  ._  _|_    |   _   _|  _   _  ._
                |  | (_| | (/_ \\/ (_) | (/_ | |  |_    |_ (/_ (_| (_| (/_ |\s
                                                                   _|      \s""");
        System.out.println("Make a selection...  ");

        while (running) {
            //System.out.println("Make another choice");
            System.out.println("d. Make a Deposit");
            System.out.println("p. Make a Payment");
            System.out.println("l. Access your Ledger");
            System.out.println("x. Exit");
            System.out.print("Enter a character here: ");
            //User should input their data (scanner)
            String choice = scanner.nextLine();

            //switch - better but can use if statements


            switch (choice) {
                // date|time|description|vendor|amount

                case "d":
                    simulateLoading("Now opening Deposit Screen ");
                    System.out.println("Enter deposit info \uD83D\uDD2A "); // prompt user for the deposit information
                    LocalDate date = LocalDate.now(); // computer generates the date and time when its .now
                    LocalTime time = LocalTime.now();

                    System.out.println("Description");
                    String description = scanner.nextLine(); //scanner.nextLine()*holds user input*
                    System.out.println("Vendor");
                    String vendor = scanner.nextLine();
                    System.out.println("Amount");
                    double amount = Double.parseDouble(scanner.nextLine()); // "wrap" it so that it changes the string(from user) to diff type

                    //date|time|description|vendor|amount
                    String deposit = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
                    FileInput(deposit);

                    break;


                case "p":
                    simulateLoading("Now opening Payment Screen ");
                    System.out.println("Enter Payment Info \uD83E\uDE78");//prompt user for the debit information and save it to the csv file
                    LocalDate dateP = LocalDate.now(); // computer generates the date and time when its .now
                    LocalTime timeP = LocalTime.now();

                    System.out.println("Description");
                    String descriptionP = scanner.nextLine(); //scanner.nextLine()*holds user input*
                    System.out.println("Vendor");
                    String vendorP = scanner.nextLine();
                    System.out.println("Amount");
                    double amountP = -1*Double.parseDouble(scanner.nextLine()); // "wrap" it so that it changes the string(from user) to diff type

                    //date|time|description|vendor|amount
                    String payment = dateP + "|" + timeP + "|" + descriptionP + "|" + vendorP + "|" + amountP;
                    FileInput(payment);
                    break; // finishes your while loop to do it again

                case "l":
                    simulateLoading("Now opening your Ledger ");
                    Ledger.showLedger();


                    break;


                case "x":
                    System.out.println("Goodbye");
                    running = false;

                    //default:
                    //System.out.println("Invalid choice, try again!");
                    //break;
            }

        }

    }

    public void FileInput(String input) {
        try {
            // create a FileWriter
            FileWriter fileWriter = new FileWriter("transactions.csv" , true);
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // write to the file
            String text;
            bufWriter.append(input + "\n");
            // close the writer
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }

    }

}
