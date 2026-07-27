/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        map.put(root,null);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                q.add(curr.left);
                map.put(curr.left,curr);
            }
            if(curr.right!=null){
                q.add(curr.right);
                map.put(curr.right,curr);
            }
        }
        HashSet<TreeNode> set=new HashSet<>();
        q.add(target);
        set.add(target);
        int level=0;
        while(!q.isEmpty()){
            if(level==k) break;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(map.get(curr)!=null && !set.contains(map.get(curr))){
                    q.add(map.get(curr));
                    set.add(map.get(curr));
                }
                if(curr.left!=null && !set.contains(curr.left)){
                    q.add(curr.left);
                    set.add(curr.left);
                }
                if(curr.right!=null && !set.contains(curr.right)){
                    q.add(curr.right);
                    set.add(curr.right);
                }
            }
            level++;
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }
}