package com.ironclad;

import java.util.Scanner;

public class AffineCipher {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String plainText = scn.nextLine();

        System.out.print("Value of a:");
        int a = scn.nextInt();

        System.out.print("Value of b:");
        int b = scn.nextInt();

        String cipherText = encryptMessage(plainText, a, b);
        System.out.println("Encrypted Text: " + cipherText);

        String decryptedText = decryptMessage(cipherText, a, b);
        System.out.println("Decrypted Text: " + decryptedText   );
    }

    private static String decryptMessage(String cipherText, int a, int b) {
        StringBuilder msg = new StringBuilder(" ");
        int aInverse = 0;
        int flag = 0;

        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;

            if (flag == 1) {
                aInverse = i;
            }
        }

        for (int i = 0; i < cipherText.length(); i++) {
            if (cipherText.charAt(i) != ' ') {
                msg.append((char) (((aInverse *
                        ((cipherText.charAt(i) + 'A' - b)) % 26)) + 'A'));
            } else {
                msg.append(cipherText.charAt(i));
            }
        }

        return msg.toString();
    }

    private static String encryptMessage(String plainText, int a, int b) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            if (plainText.charAt(i) != ' ') {
                cipher.append((char) ((((a * (plainText.charAt(i) - 'A')) + b) % 26) + 'A'));
            } else {
                cipher.append(plainText.charAt(i));
            }
        }
        return cipher.toString();
    }
}
