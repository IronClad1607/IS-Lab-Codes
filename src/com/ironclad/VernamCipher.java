package com.ironclad;

import java.util.Scanner;

public class VernamCipher {

    public static String encrypt(String plainText, String key) {
        char[] plainChar = plainText.toCharArray();
        int mod = key.length();
        int j = 0;

        StringBuilder keyBuilder = new StringBuilder(key);
        for (int i = keyBuilder.length(); i < plainText.length(); i++) {
            keyBuilder.append(keyBuilder.charAt(j % mod));
            j++;
        }
        key = keyBuilder.toString();

        char[] keyChar = key.toCharArray();
        char[] ans = new char[plainText.length()];
        for (int i = 0; i < plainText.length(); i++) {
            ans[i] = (char) ((char) (keyChar[i] - 'A' + plainChar[i] - 'A') % 26 + 'A');
        }

        return String.valueOf(ans);
    }

    public static String decrypt(String encryptedText, String key) {
        char[] encryptedChar = encryptedText.toCharArray();
        int mod = key.length();
        int j = 0;

        StringBuilder keyBuilder = new StringBuilder(key);
        for (int i = keyBuilder.length(); i < encryptedText.length(); i++) {
            keyBuilder.append(keyBuilder.charAt(j % mod));
            j++;
        }
        key = keyBuilder.toString();

        char[] keyChar = key.toCharArray();
        char[] ans = new char[encryptedText.length()];

        for (int i = 0; i < encryptedText.length(); i++) {
            ans[i] = (char) ((encryptedChar[i] - keyChar[i] + 26) % 26 + 'A');
        }

        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Plain Text:");
        String str = scn.nextLine();

        System.out.print("Key:");
        String keyword = scn.nextLine();

        String encrypted = encrypt(str, keyword);
        System.out.println("Encrypted Text:" + encrypted);

        String decrypted = decrypt(encrypted, keyword);
        System.out.println("Decrypted Text:" + decrypted);
    }
}
