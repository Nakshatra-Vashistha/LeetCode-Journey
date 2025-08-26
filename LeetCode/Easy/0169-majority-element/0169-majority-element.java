class Solution {
    public int majorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        for(int num : nums){
            if(num == candidate){
                count++;
            }
            else if(count == 0){
                candidate = num;
                count++;
            }
            else{
                count--;
            }
            
        }
        return candidate;
        
        
    }
}