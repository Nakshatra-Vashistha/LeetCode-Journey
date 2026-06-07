class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> Vset = new HashSet<>();

        while(!Vset.contains(n)){
            Vset.add(n);
            n = helper(n);
            if (n == 1){
                return true;
            }

        }

        return false;
    }

    public static int helper(int n){
        int res = 0;

        while(n > 0){
            int digit = n % 10;
            res += digit * digit;
            n = n / 10;
        }

        return res;
    }
}