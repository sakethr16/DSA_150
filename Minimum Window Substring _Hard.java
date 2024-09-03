/*
76. Minimum Window Substring

Topics
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window subst
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int len = s.length();
        int max = 0;
        while (right < len && left <= right){
            Character c = s.charAt(right);
            if (!set.contains(c)){
                set.add(c);
                max = Math.max(right - left + 1, max);
                right++;
            }
            else{
                while(s.charAt(left) != c){
                    set.remove(s.charAt(left));
                    left ++;
                }
                left ++;
                right ++;
            }
        }

        return max;
        
    }
}