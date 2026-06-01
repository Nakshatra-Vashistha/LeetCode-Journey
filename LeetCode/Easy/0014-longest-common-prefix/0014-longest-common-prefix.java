class Solution {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        Arrays.sort(strs);

        int n = strs[0].length();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            if(strs[0].charAt(i) == strs[size-1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }
            else{
                break;
            }
        }


        return sb.toString();
        
    }
}