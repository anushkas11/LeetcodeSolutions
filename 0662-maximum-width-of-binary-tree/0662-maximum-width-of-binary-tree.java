class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node, int idx){
        this.node=node;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxwidth=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int first=q.peek().idx;
            int last=first;
            for(int i=0;i<size;i++){
               Pair p=q.poll();
               TreeNode node=p.node;
               int idx=p.idx;
               last=idx;
               if(node.left!=null) q.offer(new Pair(node.left,2*idx+1));
               if(node.right!=null) q.offer(new Pair(node.right,2*idx+2));
            }
            maxwidth=Math.max(maxwidth,last-first+1);
        }
        return maxwidth;

    }
}