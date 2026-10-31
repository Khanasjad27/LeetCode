class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1,-1,-1};
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);   // phele humne curr char liya 
            lastSeen[ch - 'a'] = i;   // then us har -a kiya coz of asci way miljaae uski n uska index milgaya then wahi index pe maine curr idx daal diya 

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }

        return count;
    }
}