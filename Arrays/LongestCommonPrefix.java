/*
Problem: Longest Common Prefix
Platform: LeetCode
Link: https://leetcode.com/problems/longest-common-prefix/

Difficulty: Easy
Topic: String

Approach:
- Initialize prefix as the first string
- Iterate through all strings
- While current string does not start with prefix:
    → reduce prefix by removing last character
- Continue until prefix matches the start of every string
- If prefix becomes empty, return ""

Edge Cases:
- Empty array → return ""
- Single string → return that string
- No common prefix → return ""

Time Complexity: O(n * m)
- n = number of strings
- m = length of prefix (worst case)

Space Complexity: O(1)
- No extra space used
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.equals("")) {
                return "";
            }
        }

        return prefix;
    }
}
