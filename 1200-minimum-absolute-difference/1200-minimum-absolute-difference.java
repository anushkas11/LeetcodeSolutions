class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
       Arrays.sort(arr);
       int min=Math.abs(arr[0]-arr[1]);
       for(int i=2;i<arr.length;i++){
        min=Math.min(min,Math.abs(arr[i]-arr[i-1]));
       } 
       List<List<Integer>> list=new ArrayList<>();
       for(int i=0;i<arr.length-1;i++){
        if(Math.abs(arr[i]-arr[i+1])==min) list.add(Arrays.asList(arr[i],arr[i+1]));
       }
       return list;
    }
}