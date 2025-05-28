class Solution {

    public static int  maxu(int a , int b , int c ){
        return Math.max(a , Math.max(b , c));
    }
    public static int  minu(int a , int b, int c){
        return Math.min(a , Math.min(b , c));
    }


    public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxEnd = nums[0];
        int minEnd = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            int temp = maxu(nums[i] , maxEnd*nums[i] , minEnd*nums[i]);
            minEnd = minu(nums[i] , maxEnd*nums[i] , minEnd*nums[i]);
            maxEnd = temp;

            res = Math.max(res , maxEnd);

        }
        return res;
        
    }
}