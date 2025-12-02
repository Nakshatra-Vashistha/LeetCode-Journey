class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }
        if(n == 2) return Math.max(nums[0] , nums[1]);
        if(n == 3) return Math.max(nums[0] , Math.max(nums[1] , nums[2]));

        int firstone = nums[0];
        int firsttwo = Math.max(nums[0] , nums[1]);

        int secone = nums[1];
        int sectwo = Math.max(nums[1] , nums[2]);
        int curr1 = 0 ; 
        int curr2 = 0;

        for(int i=2 ; i<n ; i++){
            if(i >=3){
                curr2 = Math.max(sectwo , secone + nums[i]);
                secone = sectwo;
                sectwo = curr2;
            }
            if(i<n-1){
                curr1 = Math.max(firsttwo , firstone + nums[i]);
                firstone = firsttwo;
                firsttwo = curr1;
            }
        }

        return Math.max(curr1 , curr2);


        
        
    }

    
}