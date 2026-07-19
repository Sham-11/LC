class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();

        int left = 0;
        int maxx = 0;

        for(int right = 0; right<s.length(); right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxx = Math.max(maxx, right-left+1);
        }
        return maxx;
    }
}