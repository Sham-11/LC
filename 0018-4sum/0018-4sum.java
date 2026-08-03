class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null || nums.length<4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    }
                    else if (sum < target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}