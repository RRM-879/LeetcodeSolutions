/**
 * Given a string s, find the length of the longest without duplicate characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 For this problem.. we can use a sliding window with a hashset
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // we'll need the hashset window
        Set<Character> window = new HashSet<>();

        // and the left and right
        int left = 0;
        int right = 0;

        // and finally our answer
        int answer = 0;

        // while the right side of the window isn't at the end of the string...
        while(right < s.length()) {
            // if our window does not contain the character at the right side of the window
            if(!window.contains(s.charAt(right))) {
                // then we add the character to our window
                window.add(s.charAt(right));
                // calculate if the window or our current answer is bigger
                answer = Math.max(answer, window.size());
                // and increase the right size of the window
                right++;
            } else {    // what happens then when we find a duplicate?
                // we shrink our left side of the window
                window.remove(s.charAt(left));
                // and move the left side forward
                left++;
            }
        }
        // by this point we've traversed and found our maximum size
        return answer;
    }
}      
