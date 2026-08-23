class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int leftQMark = 0, rightQMark = 0;

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (i < n / 2) {
                if (c == '?'){
                    leftQMark++;
                } 
                else{
                    leftSum += (c - '0');
                }
            } else {
                if (c == '?'){
                    rightQMark++;
                }
                else{
                    rightSum += (c - '0');
                }
            }
        }

        // Each full pair of '?' managed by Alice and Bob balances out to 9 each.
        // Difference in sums must be offset by 9 * (QMark difference) / 2.
        int qMarkDiff = leftQMark - rightQMark;
        int sumDiff = leftSum - rightSum;

        if ((leftQMark + rightQMark) % 2 != 0) {
            return true; // Alice wins if total question marks are odd
        }

        return sumDiff != -9 * (qMarkDiff / 2);
    }
}
