class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null) q.add(root);
        int maxSum=Integer.MIN_VALUE ,level=1;
        int ans=level;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                sum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                q.remove();
            }
            if(sum>maxSum){
                maxSum=sum;
                ans=level;
            }
            level++;
        }
        return ans;
    }
}