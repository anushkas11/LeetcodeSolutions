class Solution {
    public int[] diStringMatch(String s) {
       TreeSet<Integer> set =new TreeSet<>();
       int n=s.length();
       for(int i=0;i<=n;i++) set.add(i);

       int ans[]=new int[n+1];
       for(int i=0;i<n;i++){
        char ch=s.charAt(i);
        if(ch=='I'){
            int first=set.first();
            ans[i]=first;
            set.remove(first);
        }
        else{
            int last=set.last();
            ans[i]=last;
            set.remove(last);
        }
       } 
       ans[n]=set.first();
       return ans;

    }
}