class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        int max=candies[0];
        for(int candy:candies) max=Math.max(max,candy);

        for(int i=0;i<candies.length;i++){
            if(extraCandies+candies[i]>=max) result.add(true);
            else result.add(false);
        }
        return result;
    }
}