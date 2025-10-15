package com.yearup;

import java.util.Scanner;

public class Ledger {
    public void showLedger() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println("Choose an option for your ledger"); // All entries should show the newest entries first


            //A) All - Display all entries
            // D) Deposits - Display only the entries that are deposits into the
            //    account
            // P) Payments - Display only the negative entries (or payments)
            // R) Reports - A new screen that allows the user to run pre-defined
            //    reports or to run a custom search
            //      1) Month To Date
            //      2) Previous Month
            //      3) Year To Date
            //      4) Previous Year
            //      5) Search by Vendor - prompt the user for the vendor name
            //    and display all entries for that vendor
            // 0) Back - go back to the Ledger page
            // H) Home - go back to the home page

            System.out.println("d. display deposit");
            System.out.println("p. display payment");
            System.out.println("r. access your report");
            System.out.println("x. exit");
            System.out.println("h. back to home screen");
            System.out.print("Pick here: ");
            //User should input their data (scanner)
            String choice = scanner.nextLine();

            switch (choice) {
                case "d":
                    System.out.println("you chose display deposit");
                    break;


                case "p":
                    System.out.println("you chose display payment");
                    break;


                case "r":
                    System.out.println("you chose display report");
                    break;


                case "x":
                    System.out.println("exit");
                    break;


                case "h":
                    System.out.println("back to home screen");
                    break;




            }
        }

    }
}
