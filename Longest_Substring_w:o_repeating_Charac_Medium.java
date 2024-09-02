/*
Longest Substring Without Repeating Characters

Topics
Companies
Hint
Given a string s, find the length of the longest 
substring
without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
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