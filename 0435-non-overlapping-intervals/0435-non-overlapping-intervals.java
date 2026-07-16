class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 && intervals.length == 1){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));
        int count = 1;
        int prev = 0;

        for(int i = 0; i<intervals.length; i++){
            if(intervals[prev][1]<=intervals[i][0]){
                prev = i;
                count++;
            }
        }
        return intervals.length-count;
    }
}