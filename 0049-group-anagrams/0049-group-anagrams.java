class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null){
            return new ArrayList<>();
        }

        Map<String, List<String>> freqMap = new HashMap<>();
        for(String str:strs){
            String freqstr = getfreq(str);  //"a2b1", "a1b1c2"

            if(freqMap.containsKey(freqstr)){
                freqMap.get(freqstr).add(str); // get "a2b1" and add that to the Map
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                freqMap.put(freqstr,strList);
            }
        }
        return new ArrayList<>(freqMap.values());
    }
    private String getfreq (String str){
        int[] freq = new int[26];

        for(char c:str.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder freqstr = new StringBuilder("");
        char c  = 'a';
        for (int i: freq){
            freqstr.append(c);
            freqstr.append(i);
            c++;
        }
        return freqstr.toString();
    }
}