class Solution {
    class Pair{
      int next;
      boolean direction;
      Pair(int next,boolean direction){
        this.next=next;
        this.direction=direction;
      }
   }
   int count=0;   
    public int minReorder(int n, int[][] connections) {
       List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int  edge[]:connections){
            int from=edge[0];
            int to=edge[1];
            graph.get(from).add(new Pair(to,true));
            graph.get(to).add(new Pair(from,false));
        }
        boolean vis[]=new boolean[n];
        dfs(0,graph,vis);
        return count; 
    }
    public void dfs(int node,List<List<Pair>> graph,boolean vis[]){
        vis[node]=true;
        for(Pair p:graph.get(node)){
            int neigh=p.next;
            boolean dir=p.direction;
           if(!vis[neigh]){
            if(dir) count++;
            dfs(neigh,graph,vis);
           }
           
        }
    }
}