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
    public int goodNodes(TreeNode root) {
        return helper(root , 0 , Integer.MIN_VALUE);
    }

    public static int helper(TreeNode root , int ans , int cur_max ){
        if(root == null){
            return 0;
        }

        int rootans = 0;
        if(root.val >= cur_max){
            rootans = 1;
            cur_max = root.val;
        }

        int lans = helper(root.left , ans , cur_max);
        int rans = helper(root.right , ans , cur_max);

        return ans = lans + rans + rootans;

    }
}