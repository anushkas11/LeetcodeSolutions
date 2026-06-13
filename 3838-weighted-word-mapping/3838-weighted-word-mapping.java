class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int k=0;
        Map<Integer,Character> map=new HashMap<>();
        for(char c='z';c>='a';c--){
            map.put(k++,c);
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++){
            int sum=0;
            for(char c:words[i].toCharArray()){
                sum+=weights[c-'a'];
            }
            sum=sum%26;
            sb.append(map.get(sum));
        }
        return sb.toString();
    }
}