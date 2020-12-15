package com.ironclad;

import java.util.Scanner;

public class CaeserCipher {

    public static String encrypt(String text, int s) {
        StringBuilder encrypted = new StringBuilder();
        return getString(text, s, encrypted);
    }

    private static String getString(String text, int s, StringBuilder encrypted) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        s - 65) % 26 + 65);
                encrypted.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        s - 97) % 26 + 97);
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String cipher, int shift) {
        StringBuilder result = new StringBuilder();

        shift = 26 - shift;

        return getString(cipher, shift, result);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Message:");
        String text = scn.nextLine();
        System.out.print("Shift By:");
        int shift = scn.nextInt();

        String caeserCode = encrypt(text, shift);
        String originalCode = decrypt(caeserCode, shift);

        System.out.println("Encrypted Message:" + caeserCode);
        System.out.println("Decrypted Message:" + originalCode);
    }
}
