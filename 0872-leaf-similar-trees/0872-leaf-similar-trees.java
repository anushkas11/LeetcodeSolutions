class Solution {
     List<Integer> list1=new ArrayList<>();
     List<Integer> list2=new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list1=leafnodes(root1,list1);
        list2=leafnodes(root2,list2);
        return list1.equals(list2);
    }
    public List<Integer> leafnodes(TreeNode root,List<Integer> list){
        if(root==null) return list;
        if(root.left==null && root.right==null) list.add(root.val);
        leafnodes(root.left,list);
        leafnodes(root.right,list);
        return list;
    }
}