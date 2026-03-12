class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);      

        int currsum = 0;
        int count = 0;

        for (int x : nums) {
            currsum += x;          
            
            count += map.getOrDefault(currsum - k, 0);

           
            map.put(currsum, map.getOrDefault(currsum, 0) + 1);
        }
        return count;
    }
}
