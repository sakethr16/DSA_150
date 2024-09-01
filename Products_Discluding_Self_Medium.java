/*
Products of Array Discluding Self
 
Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in 
O(n) time without using the division operation?

Example 1:

Input: nums = [1,2,4,6]

Output: [48,24,12,8]
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];

        int l_prod = 1;
        int r_prod = 1;

        for(int i = 0; i<len; i++){
            l[i] = l_prod;
            r[len-i-1] = r_prod;  
            l_prod = l_prod * nums[i];
            r_prod = r_prod * nums[len-1-i];
        }

        int[] res = new int[len];
        for(int i=0; i < len; i++){
            res[i] = l[i] * r[i];
        }

        return res;

    }
}  
