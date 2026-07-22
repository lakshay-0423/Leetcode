/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        dfs(root,set,list,0);
        return list;
    }
    public void dfs(TreeNode root,HashSet<Integer> set,List<Integer> list,int level){
        if(root==null) return;
        level++;
        if(!set.contains(level)){
            set.add(level);
            list.add(root.val);
        }
        dfs(root.right,set,list,level);
        dfs(root.left,set,list,level);
        level--;
    }
}