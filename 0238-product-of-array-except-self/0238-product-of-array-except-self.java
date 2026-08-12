class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        int[] answer = new int[nums.length];
        int prod1 = 1;
        int prod2 = 1;
        
        for(int i = 0; i<nums.length; i++){
            answer[i] = prod1;
            prod1 = prod1 * nums[i];
        }

        for(int i = nums.length-1; i>=0; i--){
            answer[i] = prod2 * answer[i];
            prod2 = prod2 * nums[i];
        }
        return answer;
    }
}