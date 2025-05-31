class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int index = 0;
        for(int num : nums1){
            merged[index] = num;
            index++;
        }
        for(int num : nums2){
            merged[index] = num;
            index++;
        }
        Arrays.sort(merged);
        int n = merged.length;
        double median = 0;
        if(n % 2 == 0){
            median = (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        }
        else{
            median = merged[n / 2];

        }
        return median;
    }
}