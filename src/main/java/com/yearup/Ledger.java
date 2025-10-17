package com.yearup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.yearup.Start.simulateLoading;

public class Ledger {
    private static final String fileName = "transaction.csv";
    private static  final List<Transaction> transaction = reader();


    public static void showLedger() {
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
            System.out.println("a. display all");
            System.out.println("d. display deposit");
            System.out.println("p. display payment");
            System.out.println("r. access your report");
            System.out.println("h. back to home screen");
            System.out.print("Pick here: ");
            //User should input their data (scanner)
            String choice = scanner.nextLine();

            switch (choice) {
                case "a":
                    simulateLoading("Now displaying all ");
                    displayAll(transaction);
                    break;


                case "d":
                    simulateLoading("Now displaying deposit ledger ");
                    displayDeposits(transaction);
                    break;


                case "p":
                    simulateLoading("Now displaying payment ledger ");
                    displayPayments(transaction);
                    break;


                case "r":
                    simulateLoading("Now displaying ledger report ");
                    Report report = new Report();
                    report.showReport();
                    break;

                case "h":
                    System.out.println("back to home screen");
                    return;
            }


            }
        }

    private static List<Transaction> reader(){
        List<Transaction> list = new ArrayList<Transaction>();

        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("transactions.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            // read until there is no more data
            while ((input = bufReader.readLine()) != null) {
                String[] info = input.split("\\|");
                LocalDate date = LocalDate.parse(info[0]);
                LocalTime time = LocalTime.parse(info[1]);
                String description = info[3];
                String vendor = info[3];
                double amount = Double.parseDouble(info[4]);

                Transaction entry = new Transaction(date, time, description, vendor, amount);
                list.add(entry);
            }
            // close the stream and release the resources
            bufReader.close();
        } catch (IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();

        }
        return list;
    }

    private static void displayAll(List<Transaction> list) {
        for(var i = list.size() - 1; i >= 0; i--){
            System.out.println(list.get(i).toString());
        }
    }
    private static void displayDeposits(List<Transaction> list) {
        for(var i = 0; i < list.size(); i++){
            if(list.get(i).getAmount() >= 0){
               System.out.println(list.get(i).toString());
            }
        }
    }
    private static void displayPayments(List<Transaction> list) {
        for(var i = 0; i < list.size(); i++){
            if(list.get(i).getAmount() < 0){
                System.out.println(list.get(i).toString());
            }
        }
    }

}



