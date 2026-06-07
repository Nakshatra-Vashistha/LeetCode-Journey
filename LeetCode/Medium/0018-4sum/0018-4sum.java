class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        if(n<4) return result;

        for(int i = 0 ; i < n-3 ; i++){
            for(int j = i+1 ; j < n-2 ; j++){
                int k = j+1;
                int last = n-1;
                while(k < last){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[last];

                    if(sum == target){
                        set.add(Arrays.asList(nums[i] , nums[j] , nums[k] , nums[last]));
                        k++;
                        last--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        last--;
                    }
                }
            }
        }
        result.addAll(set);
        return result;
    }
}