/* 
Is Anagram 

Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int len1 = s.length();
        int len2 = t.length();
        for(int i=0; i<len1; i++){
            int val = s.charAt(i) - 'a';
            arr[val]++;
        }
        for(int i=0; i<len2; i++){
            int val = t.charAt(i) - 'a';
            arr[val]--;
        }
        for(int i : arr){
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
