class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Integer> Smap = new HashMap<>();
        HashMap<Character , Integer> Tmap = new HashMap<>();

        for(int i = 0; i < s.length() ; i++){
            if(!Smap.containsKey(s.charAt(i))){
                Smap.put(s.charAt(i) , i );
            }

            if(!Tmap.containsKey(t.charAt(i))){
                Tmap.put(t.charAt(i) , i );
            }

            if(!Smap.get(s.charAt(i)).equals(Tmap.get(t.charAt(i)))){
                return false;
            }
        }

        return true;
        
    }
}