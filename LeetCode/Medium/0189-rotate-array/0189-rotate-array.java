class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n ;

        reverse(nums , n-k , n-1  );
        reverse(nums , 0 , n-k-1);
        reverse(nums , 0 , n-1);

        
    }

    static void reverse(int arr[] , int start , int stop){
        while( start < stop){
            int temp = arr[start];
            arr[start] = arr[stop];
            arr[stop] = temp;
            start++;
            stop--;
        }

    }
}