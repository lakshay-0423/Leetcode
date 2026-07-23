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
    int postIndex=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        postIndex=postorder.length-1;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,n-1);
    }
    public TreeNode build(int[] postorder,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[postIndex--]);
        int mid = map.get(root.val);
        root.right=build(postorder,mid+1,right);
        root.left=build(postorder,left,mid-1);
        return root;
    }
}