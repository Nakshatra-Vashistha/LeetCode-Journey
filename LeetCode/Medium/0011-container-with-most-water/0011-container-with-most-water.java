class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right){
            int w = right - left;
            int h = Math.min(height[left] , height[right]);
            int res = w * h;
            max = Math.max(max , res );

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
        
    }
}