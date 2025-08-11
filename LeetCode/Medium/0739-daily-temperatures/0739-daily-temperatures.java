class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> helper = new Stack<>();
        int n = temperatures.length;

        int[] arrayS = new int[n];

        for(int i = n-1 ; i >=0 ; i--){
            while(!helper.isEmpty() && temperatures[i] >= temperatures[helper.peek()]){
                helper.pop();

            }
            if(!helper.isEmpty()){
                arrayS[i] = helper.peek() - i;
            }
            helper.push(i);
        }
        return arrayS;

    }
}