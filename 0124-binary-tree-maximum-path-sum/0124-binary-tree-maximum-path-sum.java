class Solution {
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxsum;
    }
    public int dfs(TreeNode root){
        if(root==null) return 0;
        //negative paths to ignore krne ke liye 
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxsum=Math.max(maxsum,root.val+left+right);
        return root.val+Math.max(left,right);

    }
}