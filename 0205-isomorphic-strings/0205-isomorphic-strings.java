class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Character> mapStoT = new HashMap<>();
        HashMap<Character, Character> mapTtoS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            if (mapStoT.containsKey(cs)) {
                if (mapStoT.get(cs) != ct) return false;
            } else {
                mapStoT.put(cs, ct);
            }
            
            if (mapTtoS.containsKey(ct)) {
                if (mapTtoS.get(ct) != cs) return false;
            } else {
                mapTtoS.put(ct, cs);
            }
        }
        
        return true;
    }
}