class Solution {
    public int maxProfit(int[] prices) {
        int minprice = prices[0];
        int maxprice = 0;

        for(int i = 1 ; i < prices.length ; i++){
            minprice = Math.min(minprice , prices[i]);
            maxprice = Math.max(maxprice , prices[i] - minprice);
            
        }
        return maxprice;
        
    }
}