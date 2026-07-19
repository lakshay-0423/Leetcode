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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        List<Integer> list=new ArrayList<>();
        hasPathSum(root,targetSum,0,result,list);
        return result;
    }
    public void hasPathSum(TreeNode root, int targetSum,int sum,List<List<Integer>> result,List<Integer> list){
        if(root==null) return;
        sum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null && sum==targetSum) result.add(new ArrayList<>(list));
        hasPathSum(root.left,targetSum,sum,result,list);
        hasPathSum(root.right,targetSum,sum,result,list);
        list.remove(list.size()-1);
    }
}