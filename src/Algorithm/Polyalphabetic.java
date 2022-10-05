package Algorithm;

import java.util.Scanner;
import securityfx.MyClass;

public class Polyalphabetic {
    //Mono cipher 
    public Polyalphabetic() {
        // nothing
    }

    public String encryption(String plainText, String alphabtic) {
        try {
            plainText =  FormatText.getNextLine(plainText);

            char[] chr1 = plainText.toCharArray();
            char[] alphaKey = alphabtic.toCharArray();
            String newStringCipher = "";
            char cipher;
            int index;
            for (int i = 0; i < chr1.length; i++) {
                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        index = (chr1[i] - 97);
                        cipher = alphaKey[index];
                        newStringCipher += cipher;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        index = (chr1[i] - 65);
                        cipher = alphaKey[index];
                        newStringCipher += cipher;
                    }
                } else {
                    newStringCipher += chr1[i];
                }
            }
            return newStringCipher;
        } catch (Exception ex) {
            MyClass.showDialog("Exception", "Exception erorr :  " + ex.getMessage());
            return null;
        }
    }

    public String decryption(String cipherText, String AlphabticKey) {
        try {
            cipherText = FormatText.getNextLine(cipherText);
            //for exam defghijklmnopqrstuvwxyzabc a to z
            char[] chr1 = cipherText.toCharArray();
            char[] alphaKey = AlphabticKey.toCharArray();
            String newStringPlain = "";
            char plain;
            int k;
            for (int i = 0; i < chr1.length; i++) {
                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        for (k = 0; k < alphaKey.length; k++) {
                            if (chr1[i] == alphaKey[k]) {
                                break;
                            }
                        }
                        plain = (char) (k + 97);
                        newStringPlain += plain;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        for (k = 0; k < alphaKey.length; k++) {
                            if (chr1[i] == alphaKey[k]) {
                                break;
                            }
                        }
                        plain = (char) (k + 65);
                        newStringPlain += plain;
                    }
                } else {
                    newStringPlain += chr1[i];
                }
            }
            return newStringPlain;
        } catch (Exception ex) {
            MyClass.showDialog("Exception", "Exception erorr :  " + ex.getMessage());
            return null;
        }
    }
}
