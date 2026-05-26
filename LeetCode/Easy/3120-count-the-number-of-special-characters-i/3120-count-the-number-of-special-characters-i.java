class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr = new int[26];

        for(char x : word.toCharArray()){
            if(Character.isLowerCase(x)){
                arr[x - 'a'] |= 1;
            }
            else{
                arr[x - 'A'] |= 2;
            }
        }
        int ans = 0;

        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] == 3){
                ans++;
            }
        }

        return ans;
        
    }
}