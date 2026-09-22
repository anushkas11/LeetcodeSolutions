class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        helper(graph,0,path,ans);
        return ans;
        
    }
    private static void helper(int graph[][],int curr,List<Integer> path,List<List<Integer>> ans){
        if(curr==graph.length-1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i:graph[curr]){
            path.add(i);
            helper(graph,i,path,ans);
            path.remove(path.size()-1);
        }
    }
}