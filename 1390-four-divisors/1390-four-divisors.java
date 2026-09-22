class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int i = 0; i< nums.length; i++){
            int k = 0;
            int[] arr = new int[4];

            for (int j = 1; j<=nums[i]; j++){
                if(nums[i]%j == 0){
                    if (k<4){
                        arr[k]=j;
                    }
                    k++;
                    if (k>4){
                        break;
                    }
                }
            }
            if (k==4){
                for (int x = 0; x<4; x++){
                    sum = sum + arr[x];
                }
            }
        }
        return sum;
    }
}