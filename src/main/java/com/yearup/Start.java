package com.yearup;

import java.io.*;

public class Start {
    public static void main(String[] args) {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.showHomeScreen();


    }
    public static void simulateLoading(String message) {
        System.out.println("\n" + message + "...");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
