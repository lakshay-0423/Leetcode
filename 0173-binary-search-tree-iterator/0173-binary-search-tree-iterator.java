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
class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root=root;
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode temp=st.pop();
        int val=temp.val;
        if(temp.right!=null){
            temp=temp.right;
            while(temp!=null){
                st.push(temp);
                temp=temp.left;
            }
        }
        return val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */