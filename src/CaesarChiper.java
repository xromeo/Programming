/*
 * ulius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc

Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

Function Description

caesarCipher has the following parameter(s):

string s: cleartext
int k: the alphabet rotation factor
Returns

string: the encrypted string
Input Format

The first line contains the integer, , the length of the unencrypted string.
The second line contains the unencrypted string, .
The third line contains , the number of letters to rotate the alphabet by.

Constraints
1<= n <=100
0 <= k <=100

s is a valid ASCII string without any spaces.

Sample Input

11
middle-Outz
2
Sample Output

okffng-Qwvb
Explanation

Original alphabet:      abcdefghijklmnopqrstuvwxyz
Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

m -> o
i -> k
d -> f
d -> f
l -> n
e -> g
-    -
O -> Q
u -> w
t -> v
z -> b
 */

/**
 * CaesarChiper
 */
public class CaesarChiper {

    public static String caesarCipher(String s, int k) {
        // Write your code here

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ci = (int) c;
            // A = 65; Z = 90;
            // a = 97; z= 122;
            if (ci >= 65 && ci <= 90) {
                int r = ((ci - 65 + k) % 26) + 65;
                result += (char) r;
            } else if (ci >= 97 && ci <= 122) {
                int r = ((ci - 97 + k) % 26) + 97;
                result += (char) r;
            } else {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "Section 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC";
        System.out.println(CaesarChiper.caesarCipher(s, 3));
    }
}