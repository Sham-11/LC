class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();

        // Filling the HashMap

        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1); 
            //getOrDefault is used to calculate the count or frequency of the key in hashmap. It is like a counter.
            //Give me the frequency of n. If n doesn't exist yet, give me 0.
        }

        // Filling of keys in the list of bucket

        for(int key: map.keySet()){
            int freq = map.get(key);

            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // Resultant Array of size k

        int[] res = new int[k];
        int counter = 0;

        for(int pos = bucket.length-1; pos>=0 && counter<k; pos--){
            if(bucket[pos]!=null){
                for(int integer: bucket[pos]){
                    res[counter++]=integer;
                }
            }
        }
        return res;
    }
}