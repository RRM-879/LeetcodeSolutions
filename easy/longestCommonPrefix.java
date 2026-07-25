/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*      1st idea - look through the list of strings at int i, i < length, i++
                    then just hold continually update the longest prefix as it scans down the list
                2nd idea - with how arrays sort strings, the longest prefix will be a part of the first and the last and
                    you can iterate up from the last checking the first string against it

                1st solution first..
         */
        // Lets check our input, gotta get back into that habit
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Grab the first string to use as our initial prefix to check against
        String prefix = strs[0];

        // Compare it against the remaining
        for (int i = 0; i < strs.length; i++) {
            // so we grab the prefix at i
            while (strs[i].indexOf(prefix) != 0) {
                // and shorten it
                prefix = prefix.substring(0, prefix.length()-1);

                // exit case: if the prefix is empty here, there is no common prefix at this index
                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}