class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        int[] arr = new int[s.length()];

       for (int i = 0; i < s.length(); i++) {
         arr[i] = s.charAt(i) - '0';
       }
       for(int i=0;i<arr.length;i++){
        if(arr[i]==9) continue;
        else if(arr[i]==6){
            arr[i]=9;
            break;
        }
       }
       int n=0;
       for(int a:arr) n=n*10+a;
       return n;
    }
}