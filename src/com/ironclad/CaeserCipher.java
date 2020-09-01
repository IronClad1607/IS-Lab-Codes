package com.ironclad;

import java.util.Scanner;

public class CaeserCipher {

    public static String encrypt(String text, int s) {
        StringBuffer encrypted = new StringBuffer();
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
        StringBuffer result = new StringBuffer();

        shift = 26 - shift;

        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipher.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Message:");
        String text = scn.nextLine();
        System.out.print("Shift By:");
        int shift = scn.nextInt();

        String ceaserCode = encrypt(text, shift);
        String originalCode = decrypt(ceaserCode, shift);

        System.out.println("Encryted Message:" + ceaserCode);
        System.out.println("Decryted Message:" + originalCode);
    }
}
