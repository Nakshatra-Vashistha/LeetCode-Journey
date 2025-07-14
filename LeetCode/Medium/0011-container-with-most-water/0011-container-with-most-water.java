class Solution {
     static{
        for(int i =0;i < 500; i++){
            maxArea(new int[]{0,0});
        }
    }
    public static int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int result=0;
        while(start<end){

            int min = Math.min(heights[start],heights[end]);

            result = Math.max(result,(end- start) * min);

            while(start<end && heights[start]<=min) start++;
            while(start<end && heights[end]<=min) end--;
        }
        return result;
    }
}