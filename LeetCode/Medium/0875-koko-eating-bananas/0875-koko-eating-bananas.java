class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = 0;

        for(int n : piles){
            if(n > high){
                high = n;
            }
        }

        int ans = high;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isValid(piles, mid, h)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] piles , int k , int h){
        int hours = 0;

        for(int pile : piles){
            hours += Math.ceil(pile / k);
        }

        return hours <= h;
    }
}