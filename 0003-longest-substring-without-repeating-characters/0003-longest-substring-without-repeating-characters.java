class Solution {
    public int lengthOfLongestSubstring(String s) {

        // Using HashSet => T.C (O(2N))

        // int i = 0;
        // int j = 0;
        // int maxLength = Integer.MIN_VALUE;
        // HashSet<Character> set = new HashSet<>();
        // while(j<s.length()){
            
        //     if(set.contains(ch)){
        //         while(i<j && set.contains(ch)){
        //             set.remove(s.charAt(i));
        //             i++;
        //         }
        //     }
        //     set.add(ch);
        //     maxLength = Math.max(maxLength, j-i+1);
        //     j++;
        // }    
        // return (maxLength == Integer.MIN_VALUE )? 0 : maxLength;

        // Using HashMap => T.C (O(N))

        int i = 0, j = 0;
        int maxL = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j<s.length()){
            char ch = s.charAt(j);
            
            if (map.containsKey(ch)) {
                i = Math.max(i, map.get(ch) + 1); // Prevents 'i' from jumping backward
            }
            map.put(ch, j);
            maxL = Math.max(maxL, j-i+1);
            j++;
        }
        return (maxL == Integer.MIN_VALUE)? 0: maxL;
    }
}