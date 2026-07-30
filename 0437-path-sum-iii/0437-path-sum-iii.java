class Solution {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            dfs(node,0,targetSum);
            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);
        }
        return ans;
    }
    public void dfs(TreeNode root,long sum,int target){
        if(root==null) return;
        sum+=root.val;
        if(sum==target) ans++;
        dfs(root.left,sum,target);
        dfs(root.right,sum,target);
    }
}