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
    class Tuple{
        int col;
        int row;
        int val;
        Tuple(int col,int row,int val){
            this.col=col;
            this.row=row;
            this.val=val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Tuple> list=new ArrayList<>();
        dfs(root,list,0,0);
        Collections.sort(list,(a,b)->{
            if(a.col!=b.col) return a.col-b.col;
            if(a.row!=b.row) return a.row-b.row;
            return a.val-b.val;
        });
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if((i>0) && (list.get(i).col!=list.get(i-1).col)){
                result.add(temp);
                temp=new ArrayList<>();
            }
            temp.add(list.get(i).val);
        }
        if (!temp.isEmpty()) result.add(temp);
        return result;
    }
    public void dfs(TreeNode root,List<Tuple> list,int col,int row){
        if(root==null) return;
        list.add(new Tuple(col,row,root.val));
        dfs(root.left,list,col-1,row+1);
        dfs(root.right,list,col+1,row+1);
    }
}