class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }
        
        // Numbers ending in 0 (other than 0 itself) are not palindromes
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int original = x; // Keep a copy of x to compare later!
        int reverseNo = 0;

        while (x > 0) {
            int digit = x % 10;
            reverseNo = (reverseNo * 10) + digit;
            x = x / 10;
        }

        // Compare the reversed number with the original copy
        return original == reverseNo;
    }
}