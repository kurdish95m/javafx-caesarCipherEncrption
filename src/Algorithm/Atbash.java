package Algorithm;
public class Atbash {

    public Atbash() {
        // nothing 
    }

    public String encryption(String plainText) {
        try {
           plainText =  FormatText.getNextLine(plainText);
            char[] chr1 = plainText.toCharArray();
            String newStringCipher = "";
            int index, x, m = 26;
            char cipher;
            for (int i = 0; i < chr1.length; i++) {
                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        index = chr1[i] - 97;
                        x = ((m - 1) * (index + 1)) % m;
                        cipher = (char) (x + 97);
                        newStringCipher += cipher;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        index = chr1[i] - 65;
                        x = ((m - 1) * (index + 1)) % m;
                        cipher = (char) (x + 65);
                        newStringCipher += cipher;
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

    public String decryption(String cipher) {
        try {
            cipher =  FormatText.getNextLine(cipher);
            char[] chr1 = cipher.toCharArray();
            String newStringPlain = "";
            int index, x, m = 26;
            char plain;
            for (int i = 0; i < chr1.length; i++) {

                if (Character.isLetter(chr1[i])) {
                    if (Character.isLowerCase(chr1[i])) {
                        index = chr1[i] - 97;
                        x = ((m - 1) * (index + 1)) % m;
                        plain = (char) (x + 97);
                        newStringPlain += plain;
                    }
                    if (Character.isUpperCase(chr1[i])) {
                        index = chr1[i] - 65;
                        x = ((m - 1) * (index + 1)) % m;
                        plain = (char) (x + 65);
                        newStringPlain += plain;
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
