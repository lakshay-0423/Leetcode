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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
    }
    public TreeNode build(int[] preorder,int max){
        if(idx==preorder.length || preorder[idx]>max) return null;
        TreeNode curr=new TreeNode(preorder[idx++]);
        curr.left=build(preorder,curr.val);
        curr.right=build(preorder,max);
        return curr;
    }
}