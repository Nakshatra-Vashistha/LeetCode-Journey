class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int k = plen;

        if(plen > slen){
            return new ArrayList<>();
        }

        List<Integer> anagram = new ArrayList<>();
        int[] sMap = new int[26];
        int[] pMap = new int[26];

        for(int i = 0 ; i < plen ; i++){
            pMap[p.charAt(i) - 'a']++;
            sMap[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sMap , pMap)){
            anagram.add(0);
        }

        for(int i = plen ; i < slen ; i++){
            sMap[s.charAt(i) - 'a']++;
            sMap[s.charAt(i - plen) - 'a']--;

            if(Arrays.equals(sMap , pMap)){
                anagram.add(i - plen + 1);
            }
        }
        return anagram;


        


        
    }
}