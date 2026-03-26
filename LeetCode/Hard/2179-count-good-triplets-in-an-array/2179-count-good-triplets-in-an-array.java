class Solution {
    static int[] segTree;
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        segTree = new int[4*n];

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.put(nums2[i] , i);
        }

        long result = 0L;

        update(0 , 0 , n-1 , map.get(nums1[0]) , 1);


        for(int i = 1 ; i < n ; i++){
            int idx = map.get(nums1[i]);

            long leftcommon = query(0 , 0 , n-1 , 0 , idx);
            long leftUncommon = i - leftcommon;
            long elementsafteridxinnums2 = (n-1) - idx;

            long rightcommon = elementsafteridxinnums2 - leftUncommon;

            result += leftcommon * rightcommon;

            update(0 , 0 , n-1 , idx , 1);

        }

        return result;


    }

    private static void update(int node , int l , int r , int idx , int val){
        if(l == r){
            segTree[node] = val;
            return;
        }

        int mid = (l+r) >> 1;
        if(idx <= mid){
            update(2*node+1 , l , mid , idx, val);
        }
        else{
            update(2*node+2 , mid+1 , r , idx , val);
        }

        segTree[node] = segTree[2*node+1] + segTree[2*node+2];

    }

    private static long query(int node , int l , int r , int ql , int qr ){
        if(qr < l || ql > r){
            return 0 ;
        }
        if(ql <= l && qr >= r){
            return segTree[node];
        }

        int mid = (l+r) >> 1;

        long left = query(2*node+1 , l , mid , ql , qr);
        long right = query(2*node+2 , mid+1 , r , ql , qr);
        return left  + right;
    }
}