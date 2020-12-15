package com.ironclad;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSAAlgorithm {

    private final BigInteger N;
    private final BigInteger e;
    private final BigInteger d;

    public RSAAlgorithm() {
        Random r = new Random();
        int bitLength = 1024;
        BigInteger p = BigInteger.probablePrime(bitLength, r);
        BigInteger q = BigInteger.probablePrime(bitLength, r);
        N = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitLength / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public RSAAlgorithm(BigInteger e, BigInteger d, BigInteger N) {
        this.e = e;
        this.d = d;
        this.N = N;
    }

    private static String bytesToString(byte[] encrypted) {
        StringBuilder test = new StringBuilder();
        for (byte b : encrypted) {
            test.append(b);
        }
        return test.toString();
    }

    // Encrypt message
    public byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    }

    // Decrypt message
    public byte[] decrypt(byte[] message) {
        return (new BigInteger(message)).modPow(d, N).toByteArray();
    }

    public static void main(String[] args) {
        RSAAlgorithm obj = new RSAAlgorithm();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Plain Text:");
        String plainText = scn.nextLine();

        System.out.println("Encrypted Text:" + bytesToString(plainText.getBytes()));

        byte[] encryptedBytes = obj.encrypt(plainText.getBytes());

        byte[] decryptedBytes = obj.decrypt(encryptedBytes);
        System.out.println("Decrypted Text:" + new String(decryptedBytes));

    }
}
