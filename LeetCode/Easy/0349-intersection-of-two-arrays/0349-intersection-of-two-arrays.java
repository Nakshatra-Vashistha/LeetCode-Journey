class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                ans.add(nums1[i]);
                int val = nums1[i];

                while (i < nums1.length && nums1[i] == val) i++;
                while (j < nums2.length && nums2[j] == val) j++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else{
                i++;
            }


        }
        int[] arr = new int[ans.size()];
        for(int k = 0 ; k < ans.size() ; k++){
            arr[k] = ans.get(k);
        }

        return arr;
        
    }
}