class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int right = 0 ;
        int totalwater = 0;

        while(right < height.length){
            while(!stack.isEmpty() && height[right] > height[stack.peek()] ){
                int popped = stack.pop();
                if(stack.isEmpty()) break;
                int d = right - stack.peek() - 1;
                int fill = d * (Math.min(height[stack.peek()] , height[right]) - height[popped]);
                totalwater = totalwater + fill;

            }
            stack.push(right++);
        }
        return totalwater;
        
    }
}