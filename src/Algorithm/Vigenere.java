package Algorithm;

public class Vigenere {

    public Vigenere() {
        // nothing
    }

    public String encryption(String plainText, String keyCod) {
        try {
            plainText = FormatText.getNextLine(plainText);
            char[] chr = plainText.toCharArray();
            char[] key = keyCod.toCharArray();
            int pIndex, kIndex;
            char cipher;
            String cipherText = "";
            for (int i = 0; i < chr.length; i++) {
                if (Character.isLetter(chr[i])) {
                    if (Character.isLowerCase(chr[i])) {
                        pIndex = (chr[i] - 97);
                        kIndex = key[i % key.length] - 'a';
                        cipher = (char) ((pIndex + kIndex + 26) % 26 + 'a');
                        cipherText += cipher;
                    }
                    if (Character.isUpperCase(chr[i])) {
                        pIndex = (chr[i] - 65);
                        kIndex = key[i % key.length] - 'A';
                        cipher = (char) ((pIndex + kIndex + 26) % 26 + 'A');
                        cipherText += cipher;
                    }
                } else {
                    cipherText += chr[i];
                }
            }
            return cipherText;
        } catch (Exception ex) {
            securityfx.MyClass.showDialog("Exception error", ex.getMessage());
            return null;
        }
    }

    public String decryption(String cipherText, String keyCode) {
        try {
            cipherText = FormatText.getNextLine(cipherText);
            char[] chr = cipherText.toCharArray();
            char[] key = keyCode.toCharArray();
            int cIndex, kIndex;
            char plainText;
            String PlainText = "";
            for (int i = 0; i < chr.length; i++) {
                if (Character.isLetter(chr[i])) {
                    if (Character.isLowerCase(chr[i])) {
                        cIndex = chr[i] - 97;
                        kIndex = key[i % key.length] - 97;
                        plainText = (char) (((cIndex - kIndex + 26) % 26) + 97);
                        PlainText += plainText;
                    }
                    if (Character.isUpperCase(chr[i])) {
                        cIndex = chr[i] - 65;
                        kIndex = key[i % key.length] - 65;
                        plainText = (char) (((cIndex - kIndex + 26) % 26) + 65);
                        PlainText += plainText;
                    }
                } else {
                    PlainText += chr[i];
                }
            }
            return PlainText;
        } catch (Exception ex) {
            securityfx.MyClass.showDialog("Exception error", ex.getMessage());
            return null;
        }
    }
}
