class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> candymap = new HashSet<>();

        for(int candy : candyType){
            candymap.add(candy);
        }
        
        return Math.min(candyType.length/2 , candymap.size());
    }
}