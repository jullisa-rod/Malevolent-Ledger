package com.yearup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.yearup.Start.simulateLoading;


public class Report {
    private static  final List<Transaction> transaction = reader();
    public void showReport() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;



//     1) Month To Date
//     2) Previous Month
//     3) Year To Date
//     4) Previous Year
//     5) Search by Vendor - prompt the user for the vendor name
//        and display all entries for that vendor
//     0) Back - go back to the Ledger page

        while (running) {

            //System.out.println("Welcome to Malevolent Ledger, where we handle your money like it's our own!");
            System.out.println("1. Month to date");
            System.out.println("2. Previous Month");
            System.out.println("3. Year to Date");
            System.out.println("4. Previous Year");
            System.out.println("5. Search by Vendor");
            System.out.println("0. Return to Ledger");
            System.out.print("Pick here: ");
            //User should input their data (scanner)
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Month to date: ");
                    displayMonthToDate(transaction);
                    break;

                case "2":
                    System.out.println("Previous Month: ");
                    displayPreviousMonth(transaction);
                    break;

                case "3":
                    System.out.println("Year to Date: ");
                    displayYearToDate(transaction);
                    break;

                case "4":
                    System.out.println("Previous Year: ");
                    displayPreviousYear(transaction);
                    break;

                case "5":
                    System.out.println("Search by Vendor: ");
                    VendorSearch(transaction);
                    break;

                case "0":
                    simulateLoading("Returning back to Ledger... ");
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
    private static void displayMonthToDate(List<Transaction> list) {
        LocalDate today = LocalDate.now();
        Year currentYear = Year.of((LocalDate.now().getYear()));
        Month currentMonth = LocalDate.now().getMonth();

        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();

            if (transactionDate.getYear() == currentYear.getValue() && transactionDate.getMonth() == currentMonth) {
                System.out.println(list.get(i));
            }
        }
    }
    private static void displayPreviousMonth(List<Transaction> list) {
        LocalDate today = LocalDate.now();
        LocalDate previousMonthDate = today.minusMonths(1);
        Year previousYear = Year.of(previousMonthDate.getYear());
        Month previousMonth = previousMonthDate.getMonth();

        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();

            if (transactionDate.getYear() == previousYear.getValue() && transactionDate.getMonth() == previousMonth) {
                System.out.println(list.get(i));
            }
        }
    }
    private static void displayPreviousYear(List<Transaction> list) {
        LocalDate today = LocalDate.now();
        Year previousYearDate = Year.of(today.getYear() - 1);

        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();


            if (transactionDate.getYear() == previousYearDate.getValue()) {
                System.out.println(list.get(i));
            }
        }
    }
    private static void displayYearToDate(List<Transaction> list) {
        LocalDate today = LocalDate.now();
        Year currentYear = Year.of((LocalDate.now().getYear()));
        Month currentMonth = LocalDate.now().getMonth();

        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();

            if (transactionDate.getYear() == currentYear.getValue() && !transactionDate.isAfter(today)) {
                System.out.println(list.get(i));
            }
        }
    }
    private static void VendorSearch(List<Transaction> list) {
        Scanner search = new Scanner(System.in);
        System.out.print("Please enter vendor search: ");
        String vendorInput = search.nextLine().trim();

        for (var i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getVendor().contains(vendorInput)) {
                System.out.println(list.get(i).toString());
            }
        }
    }
}
