/*
424. Longest Repeating Character Replacement

Topics
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 
Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
 */


class Solution {
    public int characterReplacement(String s, int k) {
        
        int len = s.length();
        int[] count = new int[26];
        int l = 0;
        int res = 0;
        for(int i = 0; i<len; i++){
            count[s.charAt(i) - 'A']++;
            int maxFreq = 0; 
            for(int j=0; j< 26; j++){
                maxFreq = Math.max(maxFreq,count[j]);
            }
            while(i - l + 1 - maxFreq > k){
                count[s.charAt(l) - 'A'] --;
                l++;
            }
            res = Math.max(res, i-l+1);
        }
        
        return res;
    }
}