class Solution {
    public boolean checkString(String s) {
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a') a.add(i);
            else if(ch=='b') b.add(i);
        }
        for(int i:a){
            for(int j:b){
                if(i>j) return false;
            }
        }
        return true;
    }
}