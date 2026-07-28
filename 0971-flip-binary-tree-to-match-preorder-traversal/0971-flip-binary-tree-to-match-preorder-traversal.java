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
    int i=0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list=new ArrayList<>();
        flip(root,voyage,list);
        return list;
    }
    public void flip(TreeNode root,int[] voyage,List<Integer> list){
        if(root==null || (!list.isEmpty() && list.get(0)==-1)) return;
        if(voyage[i]!=root.val){
            list.clear();
            list.add(-1);
            return;
        }
        i++;
        if(root.left!=null && voyage[i]!=root.left.val){
            TreeNode temp=root.left;
            root.left=root.right;
            root.right=temp;
            list.add(root.val);
        }
        flip(root.left,voyage,list);
        flip(root.right,voyage,list);
    }
}