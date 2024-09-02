
/*

15. 3Sum

Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

 */


 //No need of set as it is sorted, make sure the indexs are moving ahead!!!!!

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        for(int i = 0; i < len - 2; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if( sum == 0 ){
                    List<Integer> val = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(val);
                    left++;
                    while(left < right && nums[left] == nums[left-1]){
                        left++;
                    }
                    right--;
                    while(left < right && nums[right] == nums[right + 1]){
                        right --;
                    }
                }
                else if(sum > 0){
                    right --;
                }
                else{
                    left ++;
                }
            }
        }

        return res;

    }
}