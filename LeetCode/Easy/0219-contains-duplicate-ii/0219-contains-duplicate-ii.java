class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> win = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(win.contains(nums[i])){
                return true;
            }
            win.add(nums[i]);
            if(win.size() > k){
                win.remove(nums[i - k]);
            }
        }
        return false;
        
    }
}