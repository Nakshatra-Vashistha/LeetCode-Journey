class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int max = Integer.MIN_VALUE;


        for(int i = 1 ; i < n ; i++){
            gain[i] = gain[i] + gain[i-1];
            max = Math.max(max , gain[i]);
        }
        return max < 0  ? 0 : max;
        
    }
}