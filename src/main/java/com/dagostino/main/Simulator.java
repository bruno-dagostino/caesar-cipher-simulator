package com.dagostino.main;

import com.dagostino.cipher.CaesarCipher;
import com.dagostino.cipher.CaesarCipherTwo;

import java.util.Scanner;

public class Simulator {
    private static final String MENU =
            "1. One key Caesar Cipher\n" +
                    "2. Two keys Caesar Cipher\n" +
                    "M. Print menu\n" +
                    "S. Sign out";

    private static void printMenu() {
        System.out.println(MENU);
    }

    private static void routeOp(String op, Scanner scanner) {
        int key1;
        int key2;
        String message;
        String encrypted;

        switch (op) {
            case "1":
                System.out.print("Enter key: ");
                key1 = scanner.nextInt();

                CaesarCipher caesarCipher = new CaesarCipher(key1);

                System.out.print("Enter message to encrypt: ");
                message = scanner.nextLine();

                encrypted = caesarCipher.encipher(message);
                System.out.println(encrypted);

                break;
            case "2":
                System.out.print("Enter keys separated by space: ");
                key1 = scanner.nextInt();
                key2 = scanner.nextInt();

                CaesarCipherTwo caesarCipherTwo = new CaesarCipherTwo(key1, key2);

                System.out.print("Enter message to encrypt: ");
                message = scanner.nextLine();

                encrypted = caesarCipherTwo.encipher(message);
                System.out.println(encrypted);

                break;
            case "M":
                printMenu();

                break;
            case "S":
                System.out.println("Exiting...");

                break;
            default:
                System.err.println("ERROR:Your selected choice is not valid");

                break;
        }
    }

    public static void main(String[] args) {
        String choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Caesar Cipher panel!\n");
        printMenu();

        do {
            System.out.print("\nEnter your option: ");
            choice = scanner.next();

            routeOp(choice, scanner);
        } while (!choice.equals("S"));

        System.out.println("Exited with success!");
        scanner.close();
    }
}
