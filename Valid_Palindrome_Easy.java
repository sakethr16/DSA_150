/*
125. Valid Palindrome

Topics
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 */



class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder filtered = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                filtered.append(Character.toLowerCase(c));
            }
        }
        int left = 0;
        int right = filtered.length() - 1;

        while(left < right){
            if(filtered.charAt(left) != filtered.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}