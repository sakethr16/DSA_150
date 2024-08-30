/* 
Anagram Groups
 
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:
Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
*/




// Good learning for using different datatypes

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] arr = new int[26];
            for(int i = 0; i<str.length(); i++){
                arr[str.charAt(i) - 'a'] ++;
            }
            String key = Arrays.toString(arr);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        /*
        map.forEach((key,value) -> {
            System.out.println(key);
            System.out.println(value);

        });
        */

        return new ArrayList<>(map.values());
    }
}
