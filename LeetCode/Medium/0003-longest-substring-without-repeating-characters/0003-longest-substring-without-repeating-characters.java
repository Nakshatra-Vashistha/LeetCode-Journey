class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        HashMap<Character , Integer> naksh = new HashMap<>();

        for(int right = 0 ; right < s.length(); right++){
            char curr = s.charAt(right);
            if(naksh.containsKey(curr) && naksh.get(curr) >= left){
                left = naksh.get(curr) + 1;
            }
            maxLength = Math.max(maxLength , right-left+1);
            naksh.put(curr , right);
        }
        return maxLength;
        
    }
}