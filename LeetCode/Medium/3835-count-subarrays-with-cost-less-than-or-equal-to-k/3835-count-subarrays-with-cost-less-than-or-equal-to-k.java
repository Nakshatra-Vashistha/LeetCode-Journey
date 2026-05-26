class Solution {
    public long countSubarrays(int[] nums, long k) {
        TreeSet<Integer> map = new TreeSet<>((a,b) -> {
            if(nums[a] != nums[b]){
                return Integer.compare(nums[a] , nums[b]);
            }
            return Integer.compare(a,b);
        });

        int i = 0 ;
        int j = 0;
        long ans = 0;
        int n = nums.length;

        while(j < n){
            map.add(j);
            long max = (long)nums[map.last()];
            long min = (long)nums[map.first()];
            long cnt = (long)map.size();

            while(i <= j && ((max-min) * cnt) > k){
                map.remove(i);
                i++;
                max = (long)nums[map.last()];
                min = (long)nums[map.first()];
                cnt = (long)map.size();
            }

            ans += cnt;
            j++;
        }

        return ans;


        
    }
}