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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
    public TreeNode build(int[] preorder, int ceil){
        if(i== preorder.length || preorder[i]>ceil){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = build(preorder, root.val);
        root.right= build(preorder, ceil);
        return root;
    }
}
