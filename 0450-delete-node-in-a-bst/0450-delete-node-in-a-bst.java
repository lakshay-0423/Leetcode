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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val<key) root.right=deleteNode(root.right,key);
        else if(root.val>key) root.left=deleteNode(root.left,key);
        else{
            if(root.left==null && root.right==null) root=null;
            else if(root.left==null && root.right!=null) root=root.right; 
            else if(root.left!=null && root.right==null) root=root.left;
            else{
                int val=smallest(root.right);
                root.val=val;
                root.right=deleteNode(root.right,val);
            } 
        }
        return root;
    }
    public int smallest(TreeNode root){
        if(root.left==null) return root.val;
        return smallest(root.left);
    }
}