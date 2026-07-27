class Solution {
    public int maxProduct(int[] nums) {
        int maxx = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(maxx < (nums[i]-1)*(nums[j]-1)){
                    maxx = (nums[i]-1)*(nums[j]-1);
                }
            }
        }
        return maxx;
    }
}