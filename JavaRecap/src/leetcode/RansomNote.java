package leetcode;

import java.util.HashMap;

/*
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */

public class RansomNote {
	
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            int countValue = map.getOrDefault(ch,0); //get the value of key, if key not found then return 0
            map.put(ch,countValue+1);
        }
        for(int i = 0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            int valueCount = map.getOrDefault(ch,0);
            if(valueCount==0){
                return false;
            }
            map.put(ch,valueCount-1);
        }
        return true;
 
    }

}
