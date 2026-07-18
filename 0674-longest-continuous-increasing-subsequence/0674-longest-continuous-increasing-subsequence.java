class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int subarrlen = 1;
        int maxx = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1]<nums[i]){
                subarrlen++;
                maxx = Math.max(maxx, subarrlen);
            }
            else{
                subarrlen = 1;
            }
        }
        return maxx;
    }
}