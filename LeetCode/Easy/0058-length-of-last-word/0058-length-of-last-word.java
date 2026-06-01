class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;

        int n = s.length();
        int temp = n-1;
        while(temp >= 0 && s.charAt(temp) == ' '){
            temp--;
        }
        while(temp >= 0 && s.charAt(temp) != ' '){
            result++;
            temp--;
        }

       

        return result;
        
    }
}