class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1,-1,-1};
        int count = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);   // phele humne curr char liya 
            lastSeen[ch - 'a'] = i;   // then us har -a kiya coz of asci way miljaae uski n uska index milgaya then wahi index pe maine curr idx daal diya 


            // agar thero -1 nhi hia to count ko increase karke 1 + (sub index mese subka min) => ye 1 khud ka hai and min mikale coz aage waalo ko add kardege 
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){ 
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }

        return count;
    }
}