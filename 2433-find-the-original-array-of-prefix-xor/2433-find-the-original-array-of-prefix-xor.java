class Solution {
    public int[] findArray(int[] pref) {
        int prefix[]=new int[pref.length];
        prefix[0]=pref[0];
        for(int i=1;i<pref.length;i++){
            prefix[i]=pref[i-1]^pref[i];
        }
        return prefix;
    }
}