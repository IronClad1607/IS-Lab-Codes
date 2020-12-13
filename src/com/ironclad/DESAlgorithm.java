package com.ironclad;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

public class DESAlgorithm {

    private static Cipher encryptCipher;
    private static Cipher decryptCipher;
    private static final byte[] iv = {11, 22, 33, 44, 99, 88, 77, 66};

    private static void encrypt(InputStream is, OutputStream os) throws IOException {
        os = new CipherOutputStream(os, encryptCipher);
        writeData(is, os);
    }

    private static void writeData(InputStream is, OutputStream os) throws IOException {
        byte[] buf = new byte[1024];
        int numRead = 0;
        while ((numRead = is.read(buf)) >= 0) {
            os.write(buf, 0, numRead);
        }

        os.close();
        is.close();
    }

    private static void decrypt(InputStream is, OutputStream os) throws IOException {
        is = new CipherInputStream(is, decryptCipher);
        writeData(is, os);
    }

    public static void main(String[] args) {
        String clearTextFile = "D:\\Ishaan's Folder\\Study Material\\4th Year\\IS\\source.txt";
        String cipherTextFile = "D:\\Ishaan's Folder\\Study Material\\4th Year\\IS\\cipher.txt";
        String clearTextNewFile = "D:\\Ishaan's Folder\\Study Material\\4th Year\\IS\\source-new.txt";

        try {
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            AlgorithmParameterSpec parameterSpec = new IvParameterSpec(iv);

            encryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);

            decryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, key, parameterSpec);

            encrypt(new FileInputStream(clearTextFile), new FileOutputStream(cipherTextFile));

            decrypt(new FileInputStream(cipherTextFile), new FileOutputStream(clearTextNewFile));

            System.out.println("DONE");

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | InvalidKeyException | IOException e) {
            e.printStackTrace();
        }
    }
}
