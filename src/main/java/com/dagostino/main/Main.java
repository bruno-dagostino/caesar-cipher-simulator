package com.dagostino.main;

import com.dagostino.cipher.CaesarCipher;

public class Main {
    public static void main(String[] args) {
        CaesarCipher caesarCipher1 = new CaesarCipher(23);
//        CaesarCipherTwo caesarCipher2 = new CaesarCipherTwo(23, 17);

        String encrypted1 = caesarCipher1.encipher("FIRST LEGION ATTACK EAST FLANK!");
//        String encrypted2 = caesarCipher2.encipher("First Legion");

        System.out.println(encrypted1);
//        System.out.println(encrypted2);
    }
}
