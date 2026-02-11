class Solution {
    static class pair{
        String str;
        int step;
        public pair(String str , int step){
            this.str = str;
            this.step = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        set.remove(beginWord);
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(beginWord , 1));

        while(!q.isEmpty()){
            pair curr = q.poll();
            String word = curr.str;
            int level = curr.step;
            if(word.equals(endWord)){
                return level;
            }
            int len = word.length();
            for(int i = 0 ; i<len;i++){
                char []arr = word.toCharArray();
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    if(arr[i] == ch) continue;//h--->>h skip karna hai
                    arr[i] = ch;

                    String replaceWord = new String(arr);
                    if(set.contains(replaceWord)){
                        q.offer(new pair(replaceWord , level+1));
                        set.remove(replaceWord);
                    }
                }
            }
        }
        return 0;
        
    }
}