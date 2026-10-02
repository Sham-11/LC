class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start with an empty string, 0 open, and 0 close parentheses
        result.add(""); 
        
        // Loop 2 * n times because every valid string will have exactly 2 * n characters
        for (int i = 0; i < 2 * n; i++) {
            List<String> nextLevel = new ArrayList<>();
            
            for (String str : result) {
                int open = countChar(str, '(');
                int close = countChar(str, ')');
                
                // Rule 1: Add '(' if we haven't used up all 'n' openings
                if (open < n) {
                    nextLevel.add(str + "(");
                }
                // Rule 2: Add ')' if there are open parentheses waiting to be closed
                if (close < open) {
                    nextLevel.add(str + ")");
                }
            }
            result = nextLevel; // Move to the next character position
        }
        
        return result;
    }
    
    // Helper helper method to count characters
    private int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) count++;
        }
        return count;
    }
}