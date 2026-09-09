class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        // Commas are added at intervals of 1,000, 1,000,000, 1,000,000,000, etc.
        for (long threshold = 1000; threshold <= n; threshold *= 1000) {
            totalCommas += (n - threshold + 1);
        }
        return totalCommas;
    }
}
