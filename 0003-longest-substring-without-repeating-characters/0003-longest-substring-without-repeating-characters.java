class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
            char ch = s.charAt(j); 
            if(set.contains(ch)){
                while(i<j && set.contains(ch)){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(ch);
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }    
        return (maxLength == Integer.MIN_VALUE )? 0 : maxLength;
    }
}