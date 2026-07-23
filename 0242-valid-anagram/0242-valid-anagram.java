class Solution {
    public boolean isAnagram(String s, String t) {
        // created a freq array
        int[] freq = new int[26];

        if(s.length() != t.length() ){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            // agar s ka char mila to increment n t ka mila to decrement
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // agar pure array zero hoga matlab s n t ke char ne ek dusre ko cancelled kardiya, therefore true

        for(int i=0; i<freq.length; i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
}