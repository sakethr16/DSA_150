/*
42. Trapping Rain Water

Topics
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */


class Solution {
    public int trap(int[] height) {

        int len = height.length - 1;

        int[] lval = new int[height.length];
        int[] rval = new int[height.length];

        int lmax = 0;
        int rmax = 0;

        for(int i=0; i<len; i++){
            lval[i] = lmax;
            lmax = Math.max(lmax, height[i]);
            rval[len - i] = rmax;
            rmax = Math.max(rmax, height[len - i]);
        }
        
        int sum = 0;
        for(int i=0; i<len; i++){
            sum = sum + Math.max(Math.min(lval[i], rval[i]) - height[i], 0);
        }
    
        return sum;

    }
}
