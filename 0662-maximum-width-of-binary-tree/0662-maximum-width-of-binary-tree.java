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
    class Pair{
        TreeNode root;
        int idx;
        Pair(TreeNode root,int idx){
            this.root=root;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int max=0;
        while(!q.isEmpty()){
            int size=q.size();
            int first=-1;
            int last=0;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                TreeNode curr=p.root;
                int idx=p.idx;
                if(first==-1) first=p.idx;
                last=idx;
                if(curr.left!=null) q.add(new Pair(curr.left,2*idx+1));
                if(curr.right!=null) q.add(new Pair(curr.right,2*idx+2));
                idx++;
            }
            max=Math.max(max,last-first+1);
        }
        return max;
    }
}