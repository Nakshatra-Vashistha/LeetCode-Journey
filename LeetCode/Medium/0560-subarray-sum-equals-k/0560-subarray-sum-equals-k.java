class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);      

        int total = 0;
        int count = 0;

        for (int x : nums) {
            total += x;          
            
            count += freq.getOrDefault(total - k, 0);

           
            freq.put(total, freq.getOrDefault(total, 0) + 1);
        }
        return count;
    }
}
