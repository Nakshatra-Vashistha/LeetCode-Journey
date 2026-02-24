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
    static TreeNode startNode ;
    public int amountOfTime(TreeNode root, int start) {

        HashMap<TreeNode,TreeNode>map = new HashMap<>();
        buildParentMap(root,null,map,start);
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(startNode);
        Set<TreeNode>visited = new HashSet<>();
        visited.add(startNode);
        int distance = 0;
        
        
        while(!q.isEmpty())
        {

            int size = q.size();
            for(int i = 0 ; i < size;i++)
            {
                TreeNode curr = q.poll();
                if(curr.left!=null && !visited.contains(curr.left))
                {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                 if(curr.right!=null && !visited.contains(curr.right))
                {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode parent = map.get(curr);

                if(parent!=null && !visited.contains(parent))
                {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
            distance++;
        }

        return distance-1;
    }

    public void buildParentMap(TreeNode node, TreeNode parent, HashMap<TreeNode,TreeNode>map , int start)
    {
        if(node == null) return;
        
        if(node.val == start){
            startNode = node;
        }
        
        map.put(node,parent);
        buildParentMap(node.left,node,map,start);
        buildParentMap(node.right,node,map,start);
    }
}