class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%nums.length]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i%nums.length] = -1;
            }
            else{
                nge[i%nums.length] = stack.peek();
            }

            stack.push(nums[i%nums.length]);
        }
        return nge;
    }
}