/*
String Encode and Decode
 
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
 */


class Solution {

    public String encode(List<String> strs) {
        String en = "";
        for ( String s : strs ){
            int len = s.length();
            en = en + Integer.toString(len) + "#" + s; 
        }
        System.out.println(en);
        return en;
    }

    public List<String> decode(String str) {

        int len = str.length();
        List<String> res = new ArrayList<>();
        int i = 0; 
        String value = "";
        while(i < len){
            value = value + str.charAt(i);
            if('0' <= str.charAt(i) && str.charAt(i) <= '9' && str.charAt(i+1) == '#'){
                int val = Integer.parseInt(value);
                i = i + 2;
                res.add(str.substring(i, i + val));
                value = "";
                i = i + val;
            }
            else{
                i ++;
            }
        }

        return res;
    }
}
