/*
Caesar Cipher Simulation
Author: Bruno D'Agostino
Date: August 24, 2019

Details: This file holds the code necessary to actually run the Caesar Cipher simulation. It implements a command line
 interface to operate the encryption process.

Specifications: In particular, this class implements the 1 key Caesar Cipher.
 */
// imports.
package com.dagostino.cipher;

public class CaesarCipher {
    /*
    This class will bring together components to create an actual Caesar Cipher.
     */
    private String alphabet;
    private String shiftedAlphabet;
    private int key;

    public CaesarCipher(int key) {
        /*
        Initializes the Caesar Cipher.

        key1 = One integer number specifying the shift for the alphabet.
         */
        // Set the alphabet, shifted alphabet and key.
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabet = this.shiftAlphabet(key);
        this.key = key;
    }

    public String toString() {
        return "Key 1: " + this.key;
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
            char newChar = this.encodeDecodeLetter(currChar);
            cipher.setCharAt(i, newChar);

            i = i + 1;
        }

        return cipher.toString();
    }

    public String decipher(String message) {
        /*
        Decryption == Encryption(26 - key).
         */
        CaesarCipher cc = new CaesarCipher(26 - this.key);

        return cc.encipher(message);
    }

    private char encodeDecodeLetter(char letter) {
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

            if (idx != -1) {
                String shiftedLowerCaseAlphabet = this.shiftedAlphabet.toLowerCase();
                newChar = shiftedLowerCaseAlphabet.charAt(idx);
            }
        } else if (Character.isUpperCase(letter)) {
            idx = this.alphabet.indexOf(letter);

            if (idx != -1) {
                newChar = this.shiftedAlphabet.charAt(idx);
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
