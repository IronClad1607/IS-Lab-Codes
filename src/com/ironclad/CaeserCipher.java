package com.ironclad;

import java.util.Scanner;

public class CaeserCipher {

    public static String ceaserCipher(String text, int s) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        int shift = scn.nextInt();
        String ceaserCode = ceaserCipher(text, shift);
        System.out.println(ceaserCode);
    }
}
