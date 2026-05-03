class Solution {
    public int minOperations(int[] arr) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                while(prime(arr,i)==false){
                        arr[i]=arr[i]+1;
                        count++;
                }
            }
            if(i%2!=0){
                    while(prime(arr,i)==true){
                        arr[i]=arr[i]+1;
                        count++;
                    }
            }
        }
        return count;
    }
    public static boolean prime(int arr[],int i){
        int a=arr[i];
        if(a<2){
            return false;
        }
        for( int j=2;j*j<=a;j++){
            if(a%j==0){
                return false;
            }
        }
        return true;
    }
}