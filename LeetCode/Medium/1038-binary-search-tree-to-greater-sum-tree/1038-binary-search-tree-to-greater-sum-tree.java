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
    static int running;
    public TreeNode bstToGst(TreeNode root) {
        running = 0;
        greater(root);
        return root;
    }
    public static void greater(TreeNode root){
        if(root == null){
            return;
        }

        greater(root.right);

        int v = root.val;
        root.val += running;
        running += v;

        greater(root.left);


    }
}