class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");

        if (pattern.length() != word.length) {
            return false;
        }

        HashMap<String , Integer> Wmap = new HashMap<>();
        HashMap<Character , Integer> Pmap = new HashMap<>();

        for(int i = 0 ; i < word.length ; i++){
            if(!Pmap.containsKey(pattern.charAt(i))){
                Pmap.put(pattern.charAt(i) , i);
            }

            if(!Wmap.containsKey(word[i])){
                Wmap.put(word[i] , i);
            }

            if(!Pmap.get(pattern.charAt(i)).equals(Wmap.get(word[i]))){
                return false;
            }
        }

        return true;
        
    }
}