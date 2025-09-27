class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> freq = new HashMap<>();

        for(int num : arr){
            freq.put(num , freq.getOrDefault(num , 0) + 1 );
        }

        Set<Integer> uni = new HashSet<>();
        for(int num : freq.values()){
            uni.add(num);
        }
        if(freq.size() == uni.size()){
            return true;
        }
        else{
            return false;
        }

        
    }
}