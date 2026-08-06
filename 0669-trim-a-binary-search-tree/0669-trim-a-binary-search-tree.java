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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return root;
        if(root.val>=low) root.left=trimBST(root.left,low,high);
        else return trimBST(root.right,low,high);
        if(root.val<=high) root.right=trimBST(root.right,low,high);
        else return trimBST(root.left,low,high);
        return root;
    }
}