class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] result = new int[3];

        for (int[] triple : triplets) {
            if (triple[0] > target[0] || triple[1] > target[1] || triple[2] > target[2]) {
                continue;
            }

            result[0] = Math.max(result[0], triple[0]);
            result[1] = Math.max(result[1], triple[1]);
            result[2] = Math.max(result[2], triple[2]);
        }

        return result[0] == target[0] && result[1] == target[1] && result[2] == target[2];
    }
}