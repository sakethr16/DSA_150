/*
128. Longest Consecutive Sequence

Topics
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: num
 */

class Solution {
    public int longestConsecutive(int[] nums) {

       int len = nums.length;
       HashSet<Integer> set = new HashSet<>();

       for(int i =0 ;i<len; i++){
        set.add(nums[i]);
       }

       int max = 0;
       for(int i =0 ;i<len; i++){
            int val = nums[i];
            int count = 1;
            if(!set.contains(val + 1)){
                while(set.contains(val-1)){
                    count++;
                    val--;
                }
            }
            max = Integer.max(max,count);
       }
       
       return max;


    }
}