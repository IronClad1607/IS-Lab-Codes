package com.ironclad;

import java.util.Scanner;

public class MultiplicativeCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int shift, i, n;
        String str;
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        System.out.print("Enter the Plain Text: ");
        str = sc.nextLine();
        str = str.toLowerCase();
        n = str.length();
        char[] ch1 = str.toCharArray();
        char ch3;
        char ch4;
        System.out.print("Enter the value by which each letter of the string is to be shifted: ");
        shift = sc.nextInt();

        System.out.println();
        System.out.print("Encrypted text is: ");

        for (i = 0; i < n; i++) {
            if (Character.isLetter(ch1[i])) {
                ch3 = (char) (((int) ch1[i] * shift - 97) % 26 + 97);
                str1.append(ch3);
            } else if (ch1[i] == ' ') {
                str1.append(ch1[i]);
            }
        }
        System.out.println(str1);

        int q = 0, flag = 0;
        for (i = 0; i < 26; i++) {
            if (((i * 26) + 1) % shift == 0) {
                q = ((i * 26) + 1) / shift;
                break;
            }
        }


        System.out.println();
        System.out.print("Decrypted text is: ");
        char[] ch2 = str1.toString().toCharArray();
        for (i = 0; i < str1.length(); i++) {
            if (Character.isLetter(ch2[i])) {

                ch4 = (char) (((int) ch2[i] * q - 97) % 26 + 97);
                str2.append(ch4);
            } else if (ch2[i] == ' ') {
                str2.append(ch2[i]);
            }
        }
        System.out.println(str2);
    }
}
