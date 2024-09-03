/*
567. Permutation in String

Topics
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1arr = new int[26];
        int[] s2arr = new int[26];

        for(char s : s1.toCharArray()){
            s1arr[s - 'a'] ++;
        }

        for(int i = 0; i < s1.length(); i++){
            s2arr[s2.charAt(i) - 'a'] ++;
        }

        if(Arrays.equals(s1arr,s2arr)){
            return true;
        }

        int left = 0;
        for(int i = s1.length(); i < s2.length(); i++){
            s2arr[s2.charAt(i) - 'a'] ++;
            s2arr[s2.charAt(left) - 'a'] --;
            left++;

            if(Arrays.equals(s1arr,s2arr)){
                return true;
            }
        }

        return false;
    }
}