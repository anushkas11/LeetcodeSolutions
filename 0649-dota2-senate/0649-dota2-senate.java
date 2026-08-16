class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer> r=new LinkedList<>();
        Queue<Integer> d=new LinkedList<>();

        for(int i=0;i<senate.length();i++){
            char c=senate.charAt(i);
            if(c=='R') r.add(i);
            else d.add(i);
        }

        while(!r.isEmpty() && !d.isEmpty()){
            int rad=r.poll();
            int dire=d.poll();
            if(rad<dire) r.offer(rad+n);
            else d.offer(dire+n);
        }
        return r.isEmpty()?"Dire":"Radiant";
    }
}