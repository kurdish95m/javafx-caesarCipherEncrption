package Algorithm;
//MultiplicativeCiphers

import java.util.Scanner;
import securityfx.MyClass;

/*
Encryption  -> E
Decryption  -> D
Plain text  -> P
Cipher Text -> C
Key         -> K
E = ( P * K ) mod 26
D = ( C * inv(K) ) mod 26    K^-1 inv

hello  -> xczzu
 */
public class MultiplicativeCiphers {

    public MultiplicativeCiphers() {
    }

    public String encryption(String plainText, int key) {
        try {
            plainText =  FormatText.getNextLine(plainText);
 
            char[] chr1 = plainText.toCharArray();
            char cipher;
            int index;
            String cipherText = "";
            for (int i = 0; i < chr1.length; i++) {
                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        index = (chr1[i] - 'a');
                        cipher = (char) (((index * key + 26) % 26) + 'a');
                        cipherText += cipher;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        index = (chr1[i] - 'A');
                        cipher = (char) (((index * key + 26) % 26) + 'A');
                        cipherText += cipher;
                    }
                } else {
                    cipherText += chr1[i];
                }

            }
            return cipherText;
        } catch (Exception ex) {
            MyClass.showDialog("Exception", "Exception erorr :  " + ex.getMessage());
            return null;
        }

    }

    public String decryption(String cipherText, int key) {
        try {
           cipherText =  FormatText.getNextLine(cipherText);
            char[] chr1 = cipherText.toCharArray();
            char plain;
            int index;
            String plainText = "";
            for (int i = 0; i < chr1.length; i++) {
                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        index = (chr1[i] - 'a');
                        plain = (char) (((index * getInverst(key) + 26) % 26) + 'a');
                        plainText += plain;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        index = (chr1[i] - 'A');
                        plain = (char) (((index * getInverst(key) + 26) % 26) + 'A');
                        plainText += plain;
                    }
                } else {
                    plainText += chr1[i];
                }

            }
            return plainText;
        } catch (Exception ex) {
            MyClass.showDialog("Exception", "Exception erorr :  " + ex.getMessage());
            return null;
        }

    }

    public static int getInverst(int key) {
        int a_inv = 0;
        int flag = 0;
        //Find a^-1 (the multiplicative inverse of a 
        //in the group of integers modulo m.) 
        for (int i = 0; i < 26; i++) {
            flag = (key * i) % 26;
            // Check if (a*i)%26 == 1, 
            // then i will be the multiplicative inverse of a 
            if (flag == 1) {
                a_inv = i;
            }
        }
        return a_inv;
    }
}
