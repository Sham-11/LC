class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0; // Minimum possible open parentheses remaining
        int leftMax = 0; // Maximum possible open parentheses remaining

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else { // c == '*'
                // If '*' acts as ')', it reduces minimum open count
                leftMin--; 
                // If '*' acts as '(', it increases maximum open count
                leftMax++;
            }

            // If leftMax drops below 0, it means there are too many ')'
            // even if we converted every single '*' into a '('
            if (leftMax < 0) {
                return false;
            }

            // leftMin cannot fall below 0 because we can choose to treat 
            // excess '*' as empty strings instead of close brackets
            if (leftMin < 0) {
                leftMin = 0;
            }
        }

        // The string is valid if we can successfully close all open brackets
        return leftMin == 0;
    }
}
