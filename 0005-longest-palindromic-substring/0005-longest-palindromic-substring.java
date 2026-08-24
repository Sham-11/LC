class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if(n<=1) return s;

        String longestsubstr = s.substring(0, 1);
        
        for (int i = 1; i<n; i++){
            // Odd
            int left = i;
            int right = i;
            while (s.charAt(left)==s.charAt(right)){
                left--;
                right++;

                if(left == -1 || right == n){
                    break;
                }
            }

            String substr = s.substring(left+1, right); // substring is a built-in method
            if (substr.length() > longestsubstr.length()){
                longestsubstr = substr;
            }

            // Even
            left = i-1;
            right = i;

            while(s.charAt(left) == s.charAt(right)){
                left--;
                right++;

                if(left == -1 || right == n){
                    break;
                }
            }
            substr = s.substring(left+1, right);
            if(substr.length() > longestsubstr.length()){
                longestsubstr = substr;
            }
        }
        return longestsubstr;
    }
}