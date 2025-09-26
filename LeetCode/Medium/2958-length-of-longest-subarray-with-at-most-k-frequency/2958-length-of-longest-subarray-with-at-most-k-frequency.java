class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        int left = 0;
        int max = 0;

        for(int right = 0 ; right < n ; right++){
            int occur  = map.getOrDefault(nums[right] ,0) + 1;
            if(occur > k){
                while(nums[left] != nums[right]){
                    map.put(nums[left] , map.get(nums[left]) - 1);

                    left++;
                }
                left++;
            }else{
                map.put(nums[right] , occur);
            }

            max = Math.max(max , right - left + 1);
             
        }
        return max;
        
    }
}