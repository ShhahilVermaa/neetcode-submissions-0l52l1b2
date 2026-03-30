class Solution {
    public int rob(int[] nums) {
        int rob1 = 0 , rob2 = 0;

        for(int num : nums){
            int take = num + rob2;
            int skip = rob1;

            int curr = Math.max(skip,take);
            
            rob2 = rob1;
            rob1 = curr;
        }   
        return rob1;
    }
}