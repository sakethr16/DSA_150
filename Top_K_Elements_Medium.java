/*

Top K Elements in List
 
Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Example 1:

Input: nums = [1,2,2,3,3,3], k = 2

Output: [2,3]

*/



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums){
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }
            else{
                map.put(i,1);
            }
        }

        // Pushing only k elements makes it nlog(k)!!
        // Don't push all then pop 2.
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> {return map.getOrDefault(p1, 0) - map.getOrDefault(p2, 0);});
        Set<Integer> set = map.keySet();
        for(int i : set){
            pq.add(i);
            if(pq.size() > k){
                pq.remove();
            }
        }

        int[] result = new int[k];
        int ind = 0;
        while(pq.size() > 0){
            result[ind++] = pq.remove();
        }
        return result;

    }
}
