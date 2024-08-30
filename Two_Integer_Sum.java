/*
Two Integer Sum
 
Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.

Example 1:

Input: 
nums = [3,4,5,6], target = 7

Output: [0,1]
*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i] , i);
        }
        return new int[]{};

    }
}
