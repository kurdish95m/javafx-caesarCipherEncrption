package Algorithm;

import java.util.Scanner;

public class CaesarCipher {

    public CaesarCipher() {
        // nothing 
    }

    public String encryption(String plain, int shift) {
        try {
            plain = FormatText.getNextLine(plain);
            char[] chr1 = plain.toCharArray();
            char chr2;
            int index;
            String newStringCipher = "";
            for (int i = 0; i < chr1.length; i++) {
                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        index = (chr1[i] - 97);
                        chr2 = (char) (((index + shift + 26) % 26) + 97);
                        newStringCipher += chr2;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        index = (chr1[i] - 65);
                        chr2 = (char) (((index + shift + 26) % 26) + 65);
                        newStringCipher += chr2;
                    }
                } else {
                    newStringCipher += chr1[i];
                }
            }
            return newStringCipher;
        } catch (Exception ex) {
            securityfx.MyClass.showDialog("Exception error", ex.getMessage());
            return null;
        }

    }

    public String decryption(String cipher, int shift) {
        try {
              cipher = FormatText.getNextLine(cipher);
            char[] chr1 = cipher.toCharArray();
            char chr2;
            int index;
            String newStringPlain = "";
            for (int i = 0; i < chr1.length; i++) {
                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        index = (chr1[i] - 97);
                        chr2 = (char) (((index - shift + 26) % 26) + 97);
                        newStringPlain += chr2;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        index = (chr1[i] - 65);
                        chr2 = (char) (((index - shift + 26) % 26) + 65);
                        newStringPlain += chr2;
                    }
                } else {
                    newStringPlain += chr1[i];
                }
            }
            return newStringPlain;
        } catch (Exception ex) {
            securityfx.MyClass.showDialog("Exception error", ex.getMessage());
            return null;
        }

    }
}
