class Solution {
    int ans=0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        dfs(root.right);
    }
}