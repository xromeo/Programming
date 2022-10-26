public class PalindromeIndex {

   
    public static int palindromeIndex(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start >= end)
            return -1; // already a palindrome        
        if (isPalindrome(s, start + 1, end))
            return start;
        if (isPalindrome(s, start, end - 1))
            return end;
        return -1;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }

    public static void main(String[] args) {
        String s = "hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh";
        System.out.println(PalindromeIndex.palindromeIndex(s));
        /*
         * s="baaaa";
         * System.out.println(PalindromeIndex.palindromeIndex(s));
         * s="bbaaaaa";
         * System.out.println(PalindromeIndex.palindromeIndex(s));
         * s="aaaaabb";
         * System.out.println(PalindromeIndex.palindromeIndex(s));
         * s="oruro";
         * System.out.println(PalindromeIndex.palindromeIndex(s));
         * s="aaaaaabaaa";
         * System.out.println(PalindromeIndex.palindromeIndex(s));
         * s="aabaaaaaaa";
         * System.out.println(PalindromeIndex.palindromeIndex(s));
         */
    }
}
