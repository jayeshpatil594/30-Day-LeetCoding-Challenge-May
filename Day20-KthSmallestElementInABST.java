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
    //ArrayList<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
    // Time : O(h + k) Space : O(h + k)
       Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0){
                return root.val;
            }
            root = root.right;
        }
       /* dfsInorder(root);
        return res.get(k - 1); */
    }
    //Time : O(n) Space : O(n)
   /* public void dfsInorder(TreeNode root){
        if(root == null){
            return;
        }
        dfsInorder(root.left);
        res.add(root.val);
        dfsInorder(root.right);
    } */
}
