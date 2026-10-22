class Solution {
    public int minOperations(int[] arr) {
        int n = arr.length;
        int asc = 1, dsc = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == (arr[i - 1] + 1) % n)
                asc++;            
            if (arr[i - 1] == (arr[i] + 1) % n)
                dsc++;
        }

        if (asc == n)
            return arr[0] == 0 ? 0 : Math.min(n - arr[0], arr[0] + 2);

        if (dsc == n)
            return Math.min(n - arr[n - 1], arr[n - 1]) + 1;

        return -1;
    }
}