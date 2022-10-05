package Algorithm;

/* a >> is key one 
              b >> is key two
             Avoid space to be encrypted 
             applying encryption formula ( a x + b ) mod m 
	     here x is msg[i] and m is 26  and added 'A' to 
	     bring it in range of ascii alphabet[ 65-90 | A-Z ] 

            Applying decryption formula a^-1 ( x - b ) mod m 
            here x is cipher[i] and m is 26} and added 'A' 
	    to bring it in range of ASCII alphabet[ 65-90 | A-Z ] 
 */
public class AffineCipher {

    public AffineCipher() {
    }

    public String encryption(String plain, int keyOne, int keyTwo) {

        try {
            String cipherText = "";
            int index;
            char cipher;
            char[] ch = plain.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (Character.isLetter(ch[i])) {
                    if (Character.isLowerCase(ch[i])) {
                        index = ch[i] - 97;
                        cipher = (char) ((((index * keyOne) + keyTwo) % 26) + 97);
                        cipherText += cipher;
                    }
                    if (Character.isUpperCase(ch[i])) {
                        index = ch[i] - 65;
                        cipher = (char) ((((index * keyOne) + keyTwo) % 26) + 65);
                        cipherText += cipher;
                    }

                } else {
                    cipherText += ch[i];
                }

            }
            return cipherText;
        } catch (Exception ex) {
            securityfx.MyClass.showDialog("Exception error", ex.getMessage());
            return null;
        }
    }

    public String decryption(String cipher, int keyOne, int keyTwo) {
        try {
            int index;
            String plainText = "";
            char plain;
            char[] ch = cipher.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (Character.isLetter(ch[i])) {
                    if (Character.isLowerCase(ch[i])) {
                        index = ch[i] - 97;
                        plain = (char) (((getInverst(keyOne) * (index - keyTwo + 26)) % 26) + 97);
                        plainText += plain;
                    }
                    if (Character.isUpperCase(ch[i])) {
                        index = ch[i] - 65;
                        plain = (char) (((getInverst(keyOne) * (index - keyTwo + 26)) % 26) + 65);
                        plainText += plain;
                    }
                } else {
                    plainText += ch[i];
                }

            }
            return plainText;
        } catch (Exception ex) {
            securityfx.MyClass.showDialog("Exception error", ex.getMessage());
            return null;
        }

    }

    public int getInverst(int key) {
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
