class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
       for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }
        boolean vis[]=new boolean[n];
        return dfs(graph,source,destination,vis);
    }
    public boolean dfs(List<List<Integer>> graph,int node, int destination,boolean []vis){
        if (node == destination) {
            return true;
        }
        vis[node]=true;
        for(int neigh:graph.get(node)){
            if(neigh==destination) return true;
            if(!vis[neigh]){
                if(dfs(graph,neigh,destination,vis)) return true;
            }
        }
        return false;
    }
}