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
    static int maxSum;
    static int inf = (int)1e9;
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        helper(root);
        return maxSum;
    }

    private int[] helper(TreeNode root){
        if(root == null){
            return new int[] {1 , inf , -inf , 0};
        }

        int[] leftBST = helper(root.left);
        int[] rightBST = helper(root.right);

        int currVal = root.val;

        boolean leftValid = (leftBST[0] == 1);
        boolean rightValid = (rightBST[0] == 1);
        boolean currValid = (leftBST[2] < currVal && rightBST[1] > currVal);

        if(leftValid && rightValid && currValid){
            int sum = currVal + leftBST[3] + rightBST[3];

            maxSum = Math.max(maxSum , sum);

            int BSTmin = Math.min(currVal , leftBST[1]);
            int BSTmax = Math.max(currVal , rightBST[2]);

            return new int[]{1 , BSTmin , BSTmax , sum };
        }

        return new int[]{0,0,0,0};
    }

}