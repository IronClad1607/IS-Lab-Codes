package com.ironclad;

import java.util.Scanner;

public class DiffieHellmanAlgorithm {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Modulo(p):");
        int p = scn.nextInt();
        System.out.print("Enter Primitive Root of " + p + ":");
        int g = scn.nextInt();
        System.out.print("Enter 1st Secret Number:");
        int a = scn.nextInt();
        System.out.print("Enter 2nd Secret Number:");
        int b = scn.nextInt();

        int A = (int) Math.pow(g, a) % p;
        int B = (int) Math.pow(g, b) % p;

        int S_A = (int) Math.pow(B, a) % p;
        int S_B = (int) Math.pow(A, b) % p;

        if (S_A == S_B) {
            System.out.println("1st Person and 2nd Person can communicate with each other!");
            System.out.println("They share a secret number:" + S_A);
        } else {
            System.out.println("1st Person and 2nd Person can't communicate with each other!");
        }
    }
}
