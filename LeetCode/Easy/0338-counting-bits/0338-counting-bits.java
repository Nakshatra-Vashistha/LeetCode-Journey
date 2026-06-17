class Solution {
    static{
        for(int i=0; i<300;i++)
            countBits(i);
    }
    static public int[] countBits(int n) {

        int[] ans = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}