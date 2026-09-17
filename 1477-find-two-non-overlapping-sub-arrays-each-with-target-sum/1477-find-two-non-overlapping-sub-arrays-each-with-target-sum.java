import java.util.Arrays;

public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        // minLenTill[i] stores the minimum length of a valid subarray ending at or before index i
        int[] minLenTill = new int[n];
        Arrays.fill(minLenTill, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int minTotalLength = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;
        
        // Sliding window over the array
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink the window from the left if the sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            // Found a valid subarray with the exact target sum
            if (currentSum == target) {
                int currentLen = right - left + 1;
                
                // If a valid non-overlapping subarray exists before 'left'
                if (left > 0 && minLenTill[left - 1] != Integer.MAX_VALUE) {
                    minTotalLength = Math.min(minTotalLength, currentLen + minLenTill[left - 1]);
                }
                
                // Track the smallest valid single subarray length seen up to the current right pointer
                currentMinLen = Math.min(currentMinLen, currentLen);
            }
            
            // Persist the best found length into our DP tracking array
            minLenTill[right] = currentMinLen;
        }
        
        // Return -1 if we couldn't find two non-overlapping subarrays
        return minTotalLength == Integer.MAX_VALUE ? -1 : minTotalLength;
    }
}
