class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> seen=new HashSet<>();
        return dfs(root,k,seen);
    }
    public boolean dfs(TreeNode root,int k,HashSet<Integer> seen){
        if(root==null) return false;
        int need=k-root.val;
        if(seen.contains(need)) return true;

        seen.add(root.val);
        return dfs(root.left,k,seen)||dfs(root.right,k,seen);
    }
}