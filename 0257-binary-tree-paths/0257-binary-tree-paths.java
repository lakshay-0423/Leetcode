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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        dfs(root,"",result);
        return result;
    }
    public void dfs(TreeNode root,String s,List<String> result){
        if(root==null) return;
        s+=root.val;
        if(root.left==null && root.right==null){
            result.add(s);
            return;
        }
        s+="->";
        dfs(root.left,s,result);
        dfs(root.right,s,result);
    }
}