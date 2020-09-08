package com.ironclad;

import java.util.Scanner;

public class ColumnarTransposition {

    public static String encrypt(String plainText, String key, int row, int column, int[][] plainMatrix, int[][] cipherMatrix) {
        int i, j;
        int k = 0;

        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                if (k < plainText.length()) {
                    plainMatrix[i][j] = (int) plainText.charAt(k);
                    k++;
                } else {
                    break;
                }
            }
        }

        for (i = 0; i < column; i++) {
            int currentCol = ((int) key.charAt(i) - 48) - 1;
            for (j = 0; j < row; j++) {
                cipherMatrix[j][i] = plainMatrix[j][currentCol];
            }
        }

        System.out.println("Encryption Table");
        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                System.out.print((char) cipherMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        String ct = "";
        for (i = 0; i < column; i++) {
            for (j = 0; j < row; j++) {
                if (cipherMatrix[j][i] == 0)
                    ct = ct + 'x';
                else {
                    ct = ct + (char) cipherMatrix[j][i];
                }
            }
        }

        return ct;
    }

    public static String decrypt(String cipherText, String key, int row, int column, int[][] plainMatrix, int[][] cipherMatrix) {
        int i, j;
        int k = 0;

        for (i = 0; i < column; i++) {
            int currentCol = ((int) key.charAt(i) - 48) - 1;
            for (j = 0; j < row; j++) {
                plainMatrix[j][currentCol] = cipherMatrix[j][i];
            }
        }

        System.out.println("Decryption Table");
        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                System.out.print((char) plainMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        String pt = "";
        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                if (plainMatrix[i][j] == 0)
                    pt = pt + "";
                else {
                    pt = pt + (char) plainMatrix[i][j];
                }
            }
        }

        return pt;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Plain Text: ");
        String plainText = scn.nextLine();
        System.out.print("Enter Key:");
        String key = scn.nextLine();


        int columnLength = key.length();
        int rowLength = (plainText.length() + columnLength) / columnLength;

        int[][] plainMatrix = new int[rowLength][columnLength];
        int[][] cipherMatrix = new int[rowLength][columnLength];

        String encrypted = encrypt(plainText, key, rowLength, columnLength, plainMatrix, cipherMatrix);
        System.out.println("Encrypted Text:" + encrypted);

        String decrypted = decrypt(encrypted, key, rowLength, columnLength, plainMatrix, cipherMatrix);
        System.out.println("Decrypted Text:" + decrypted);

    }
}
