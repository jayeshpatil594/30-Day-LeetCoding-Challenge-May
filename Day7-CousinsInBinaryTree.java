class Solution {
    //Method1 : DFS Time : O(n) Space : O(n) ..where n is the height of tree.
    int leftChildDepth = -1;
    int rightChildDepth = -1;
    
    TreeNode leftChildParent = null;
    TreeNode rightChildParent = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, x, y, 0, null);
        return leftChildDepth == rightChildDepth && leftChildParent != rightChildParent;
    }
    public void helper(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        else if(root.val == x){
            leftChildDepth = depth;
            leftChildParent = parent;
        }
        else if(root.val == y){
            rightChildDepth = depth;
            rightChildParent = parent;
        }
        else{
            helper(root.left, x, y, depth + 1, root);
            helper(root.right, x, y, depth + 1, root);
        }
    }
    /* Merhod 2: BFS: Time: O(n) Space: O(n)
    if(root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        while(!queue.isEmpty()){
            
            boolean xFound = false;
            boolean yFound = false;
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.val == x) { xFound = true; }
                if(curr.val == y) { yFound = true; }
                
                if(curr.left != null && curr.right != null){
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }         
                }
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            if(xFound && yFound){
                return true;
            }
        }
        return false;
    */
}
