class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> myList = new ArrayList<>();

        int max = 0;
        for(int i = 0 ; i < candies.length ; i++){
            if(candies[i] > max){
                max = candies[i];
            }
        }

        for(int i = 0 ; i < candies.length ; i++){
            if(candies[i] + extraCandies >= max){
                myList.add(true);
            }else{
                myList.add(false);
            }
        }

        return myList;
        
    }
}