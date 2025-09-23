class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();

        for(String c : operations){
            if(c.equals("+")){
                int top = stk.pop();
                int newtscore = top + stk.peek();
                stk.push(top);
                stk.push(newtscore);
            }
            else if (c.equals("D")){
                stk.push(2 * stk.peek());
            }
            else if (c.equals("C")){
                stk.pop();
            }
            else{
                stk.push(Integer.parseInt(c));
            }
        }
        int sum = 0;
        for (int score : stk) {
            sum += score;
        }
        return sum;
        
    }
}