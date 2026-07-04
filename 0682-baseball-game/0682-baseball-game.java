class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list=new ArrayList<>();
        for(String s:operations){
            if(s.equals("+")){
                if(list.size()>=2){
                    int a=list.get(list.size()-1);
                    int b=list.get(list.size()-2);
                    list.add(a+b);
                }
            }
            else if(s.equals("D")) list.add(2*list.get(list.size()-1));
            else if(s.equals("C")){
                if(!list.isEmpty())
                list.remove(list.size()-1);
            }
            else list.add(Integer.parseInt(s));
        }
        int sum=0;
        for(int x:list) sum+=x;
        return sum;
    }
}