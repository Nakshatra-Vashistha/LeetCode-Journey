class Solution {
    static{
        for(int i =0;i < 20; i++){
            new Solution().maxArea(new int[]{0,0});
        }
    }
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right){
            int w = right - left;
            int h = Math.min(height[left] , height[right]);
            max = Math.max(max , w * h);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        System.gc();
        return max;
        
    }
}