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
    static ArrayList<Integer> ans ;
    public boolean findTarget(TreeNode root, int k) {
        ans = new ArrayList<>();
        Inorder(root);
        int left = 0;
        int right = ans.size()-1;

        while(left < right){
            int sum = ans.get(left) + ans.get(right);

            if(sum == k) return true;
            else if(sum < k){
                left++;
            }
            else{
                right--;
            }
        }


        return false;
        
    }

    public static void Inorder(TreeNode root){
        if(root == null){
            return ;
        }

        Inorder(root.left);
        ans.add(root.val);
        Inorder(root.right);
    }
}