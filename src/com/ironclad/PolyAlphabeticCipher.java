package com.ironclad;

import java.util.Scanner;

public class PolyAlphabeticCipher {
    public static String generateKey(String str, String key) {
        int x = str.length();

        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;

            key += (key.charAt(i));
        }

        return key;
    }

    public static String encryptText(String str, String key) {
        String cipherText = "";

        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i)) % 26;

            x += 'A';

            cipherText += (char) (x);
        }

        return cipherText;
    }

    public static String decryptText(String cipher_text, String key) {
        String orgText = "";

        for (int i = 0; i < cipher_text.length() && i < key.length(); i++) {
            int x = (cipher_text.charAt(i) - key.charAt(i) + 26) % 26;

            x += 'A';
            orgText += (char) (x);
        }

        return orgText;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Plain Text:");
        String str = scn.nextLine();

        System.out.print("Keyboard:");
        String keyword = scn.nextLine();

        String key = generateKey(str, keyword);
        String cipherText = encryptText(str, key);
        String originalText = decryptText(cipherText, key);

        System.out.println("Encrypted Text:" + cipherText);
        System.out.println("Decrypted Text:" + originalText);
    }
}
