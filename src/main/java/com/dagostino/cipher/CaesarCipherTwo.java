/*
Caesar Cipher Simulation
Author: Bruno D'Agostino
Date: August 24, 2019

Details: This file holds the code necessary to actually run the Caesar Cipher simulation. It implements a command line
 interface to operate the encryption process.

Specifications: In particular, this class implements the 2 keys Caesar Cipher.
 */
// imports.
package com.dagostino.cipher;

public class CaesarCipherTwo {
    /*
    This class will bring together components to create an actual 2 keys Caesar Cipher.
     */
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int key1;
    private int key2;

    public CaesarCipherTwo(int key1, int key2) {
        /*
        Initializes the Caesar Cipher.

        key1 = One integer number specifying the shift for the first alphabet.

        key2 = One integer number specifying the shift for the second alphabet.
         */
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet1 = this.shiftAlphabet(key1);
        this.shiftedAlphabet2 = this.shiftAlphabet(key2);
        this.key1 = key1;
        this.key2 = key2;
    }

    public String toString() {
        return "Key 1: " + this.key1 + ",\tKey 2: " + this.key2;
    }

    public String encipher(String message) {
        /*
        Given a message string, encode that message.
         */
        StringBuilder cipher = new StringBuilder(message);

        // TODO
        // Test the message string to make sure it only contains a-zA-Z

        int i = 0;
        while (i < cipher.length()) {
            char currChar = cipher.charAt(i);
            char newChar = this.encodeDecodeLetter(currChar, i);
            cipher.setCharAt(i, newChar);

            i = i + 1;
        }

        return cipher.toString();
    }

    public String decipher(String message) {
        /*
        Decryption == Encryption(26 - key1, 26 - key2).
         */
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - this.key1, 26 - this.key2);

        return cc.encipher(message);
    }

    private char encodeDecodeLetter(char letter, int i) {
        /*
        Takes a letter as input and returns letter output.
         */
        char newChar = 0;

        // TODO
        // Make sure the letter is in a-zA-Z.

        int idx;
        if (Character.isLowerCase(letter)) {
            String lowerCaseAlphabet = this.alphabet.toLowerCase();
            idx = lowerCaseAlphabet.indexOf(letter);

            if (idx != -1 && i % 2 == 0) {
                String shiftedLowerCaseAlphabet = this.shiftedAlphabet1.toLowerCase();
                newChar = shiftedLowerCaseAlphabet.charAt(idx);
            } else if (idx != -1 && i % 2 == 1) {
                String shiftedLowerCaseAlphabet = this.shiftedAlphabet2.toLowerCase();
                newChar = shiftedLowerCaseAlphabet.charAt(idx);
            }
        } else if (Character.isUpperCase(letter)) {
            idx = this.alphabet.indexOf(letter);

            if (idx != -1 && i % 2 == 0) {
                newChar = this.shiftedAlphabet1.charAt(idx);
            } else if (idx != -1 && i % 2 == 1) {
                newChar = this.shiftedAlphabet2.charAt(idx);
            }
        } else {
            newChar = letter;
        }

        return newChar;
    }

    private String shiftAlphabet(int key) {
        return this.alphabet.substring(key) + this.alphabet.substring(0, key);
    }
}
