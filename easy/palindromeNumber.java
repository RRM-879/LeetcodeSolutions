/* Given an integer x, return true if x is a , and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/

class Solution {
    public boolean palindromeNumber(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while(x > 0) {
            // strip the last digit
            int lastDigit = x % 10;

            // Build the reversed number
            reversed = (reversed * 10) + lastDigit;

            // strip the last digit from original input x
            x = x / 10;
        }

        return original == reversed;
    }
}