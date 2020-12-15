package com.ironclad;

import java.util.Scanner;

public class PolyAlphabeticCipher {
    public static String generateKey(String str, String key) {
        int x = str.length();

        StringBuilder keyBuilder = new StringBuilder(key);
        for (int i = 0; ; i++) {
            if (x == i)
                i = 0;
            if (keyBuilder.length() == str.length())
                break;

            keyBuilder.append(keyBuilder.charAt(i));
        }
        key = keyBuilder.toString();

        return key;
    }

    public static String encryptText(String str, String key) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i)) % 26;

            x += 'A';

            cipherText.append((char) (x));
        }

        return cipherText.toString();
    }

    public static String decryptText(String cipher_text, String key) {
        StringBuilder orgText = new StringBuilder();

        for (int i = 0; i < cipher_text.length() && i < key.length(); i++) {
            int x = (cipher_text.charAt(i) - key.charAt(i) + 26) % 26;

            x += 'A';
            orgText.append((char) (x));
        }

        return orgText.toString();
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
