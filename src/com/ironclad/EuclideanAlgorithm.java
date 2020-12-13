package com.ironclad;

import java.util.Scanner;

public class EuclideanAlgorithm {
    public static int gcdExtended(int a, int b, int x, int y) {

        //Base Case
        if (a == 0) {
            x = 0;
            y = 0;
            return b;
        }

        int x1 = 1, y1 = 1;
        int gcd = gcdExtended(b % a, a, x1, y1);
        x = y1 - (b / a) * x1;
        y = x1;
        System.out.println("x :" + x + " " + "y: " + y);
        return gcd;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 1, y = 1;
        System.out.print("Enter value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter value of b: ");
        int b = scanner.nextInt();
        System.out.println("GCD of " + a + " and " + b + ": " + gcdExtended(a, b, x, y));
    }
}
