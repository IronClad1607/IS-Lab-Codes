package com.ironclad;

import java.util.Scanner;

public class RailFenceCipher {

    public static String encrypt(String plainText, int depth) {
        int len = plainText.length();
        int c = len / depth;
        char[][] mat = new char[depth][c];
        int k = 0;

        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < depth; j++) {
                if (k != len) {
                    mat[j][i] = plainText.charAt(k++);
                } else {
                    mat[j][i] = 'X';
                }
            }
        }

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < c; j++) {
                cipher.append(mat[i][j]);
            }
        }


        return cipher.toString();
    }

    public static String decrypt(String cipherText, int depth) {
        int len = cipherText.length();
        int c = len / depth;
        char[][] mat = new char[depth][c];
        int k = 0;

        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = cipherText.charAt(k++);
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < depth; j++) {
                plainText.append(mat[j][i]);
            }
        }

        return plainText.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Plain Text:");
        String plainText = scn.nextLine();
        System.out.print("Enter Depth:");
        int depth = scn.nextInt();

        String encryptedText = encrypt(plainText, depth);
        System.out.println("Encrypted Text:" + encryptedText);

        String decryptedText = decrypt(encryptedText, depth);
        System.out.println("Decrypted Text:" + decryptedText);
    }
}
