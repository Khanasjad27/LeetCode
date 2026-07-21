class Solution {
    public boolean isPalindrome(String s) {
        int f = 0;
        int l = s.length()-1;
        while(f<=l){
            // agar char letter ya digit nhi hai then we will ignor
            while(f<l && !Character.isLetterOrDigit(s.charAt(f))){
                f++;
            }
            while(f<l && !Character.isLetterOrDigit(s.charAt(l))){
                l--;
            }

            if(Character.toLowerCase(s.charAt(f)) != Character.toLowerCase(s.charAt(l))){ 
                // makinng the character to lower case then comparing 
                return false;
            }
            f++;
            l--;
        }
        return true;
    }
}