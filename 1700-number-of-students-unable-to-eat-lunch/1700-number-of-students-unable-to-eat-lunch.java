class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count[]=new int[2];
        for(int student:students) count[student]++;

        for(int i=0;i<sandwiches.length;i++){
            int sand=sandwiches[i];
            if(count[sand]==0) return sandwiches.length-i;
            count[sand]--;
        }
        return 0;
    }
}