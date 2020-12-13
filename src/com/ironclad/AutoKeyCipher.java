package com.ironclad;

import java.util.Scanner;

public class AutoKeyCipher {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encryption(String msg, String key) {
        int length = msg.length();
        String newKey = key.concat(msg);
        newKey = newKey.substring(0, newKey.length() - key.length());
        StringBuilder encryptMessage = new StringBuilder();

        for (int x = 0; x < length; x++) {
            int first = alphabet.indexOf(msg.charAt(x));
            int second = alphabet.indexOf(newKey.charAt(x));

            int total = (first + second) % 26;
            encryptMessage.append(alphabet.charAt(total));
        }

        return encryptMessage.toString();
    }

    public static String decryption(String msg, String key) {
        StringBuilder currentKey = new StringBuilder(key);
        StringBuilder decryptMessage = new StringBuilder();

        for (int x = 0; x < msg.length(); x++) {
            int get1 = alphabet.indexOf(msg.charAt(x));
            int get2 = alphabet.indexOf(currentKey.charAt(x));
            int total = (get1 - get2) % 26;
            total = (total < 0) ? total + 26 : total;
            decryptMessage.append(alphabet.charAt(total));
            currentKey.append(alphabet.charAt(total));
        }

        return decryptMessage.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Plain Text: ");
        String plainText = scn.nextLine();
        System.out.print("Auto key: ");
        String key = scn.nextLine();

        if (key.matches("[-+]?\\d*\\.?\\d+")) {
            key = "" + alphabet.charAt(Integer.parseInt(key));
        }

        String enc = encryption(plainText, key);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + decryption(enc, key));
    }
}
