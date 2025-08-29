class Solution {
    public String reverseVowels(String s) {
        char[] sb = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(!Vowel(sb[left])){
                left++;
                continue;
            }
            if(!Vowel(sb[right])){
                right--;
                continue;
            }

            char temp = sb[left];
            sb[left] = sb[right];
            sb[right] = temp;
            left++;
            right--;
        }
        String str = String.valueOf(sb);

        return str;
        
    }

    public Boolean Vowel(char v){
        if((v == 'a') || (v == 'e') || (v == 'i') || (v == 'o') || (v == 'u') || (v == 'A') || (v == 'E') || (v == 'I') || (v == 'O') ||(v == 'U')){
            return true;
        }
        else{
            return false;
        }
    }
}