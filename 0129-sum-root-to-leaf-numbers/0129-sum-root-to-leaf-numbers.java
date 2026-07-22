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
    public int sumNumbers(TreeNode root) {
        int[] arr=new int[1];
        dfs(root,arr,0);
        return arr[0];
    }
    public void dfs(TreeNode root,int[] arr,int num){
        if(root==null) return;
        num=num*10+root.val;
        if(root.left==null && root.right==null){
            arr[0]+=num;
            return;
        }
        dfs(root.left,arr,num);
        dfs(root.right,arr,num);
    }
}