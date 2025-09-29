class Solution {
    public int minStartValue(int[] nums) {
        int startvalue = 0;
        int prefix = 0;

        for(int num : nums){
            prefix += num;
            if(prefix < startvalue){
                startvalue = prefix;
            }

        }
        return (startvalue >= 1) ? 1 : (startvalue*-1) + 1;
        
    }
}