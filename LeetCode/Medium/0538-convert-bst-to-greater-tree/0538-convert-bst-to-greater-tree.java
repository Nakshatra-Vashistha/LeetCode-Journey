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
    static int runningsum;
    public TreeNode convertBST(TreeNode root) {
        runningsum = 0;
        buildGreaterTree(root);
        return root;
        
    }

    public static void buildGreaterTree(TreeNode root){
        if(root == null){
            return;
        }

        buildGreaterTree(root.right);

        
        int ogvalue = root.val;
        root.val += runningsum;
        runningsum += ogvalue;

        buildGreaterTree(root.left);




    }
}