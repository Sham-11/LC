class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int longestStreak = 0;

        for(int num: set){
            if(!set.contains(num-1)){
                int currStreak = 1;

                while(set.contains(num+1)){
                    num = num+1;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}