class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = 0;

        for(int p : piles ){
            if(p > high){
                high = p;
            }
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high-low) / 2;
            if(isValid(piles , mid , h )){
                ans = mid;
                high = mid-1;

            }
            else{
                low = mid+1;
            }

        }
        return ans;
        
    }

    public boolean isValid(int[] piles , int mid , int h){
        int hours = 0;

        for(int p : piles){
            hours += Math.ceil((double)p / mid);
        }

        return hours <= h ;

        
    }
}