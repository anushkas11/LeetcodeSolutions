class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int minVal, int maxVal) {
        if (node == null) {
            return maxVal - minVal;
        }

        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);

        int leftDiff = dfs(node.left, minVal, maxVal);
        int rightDiff = dfs(node.right, minVal, maxVal);

        return Math.max(leftDiff, rightDiff);
    }
}