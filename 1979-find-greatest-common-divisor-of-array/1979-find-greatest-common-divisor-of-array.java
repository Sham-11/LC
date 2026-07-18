class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return gcd(nums[0], nums[n-1]);
    }
    private int gcd(int a, int b){
        int small = Math.min(a,b);
        int large = Math.max(a,b);

        if(large%small == 0){
            return small;
        }
        for(int i = small-1; i>=0; i--){
            if(small%i==0 && large%i==0){
                return i;
            }
        }
        return 1;
    }
}