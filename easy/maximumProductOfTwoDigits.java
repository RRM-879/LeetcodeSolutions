/* You are given a positive integer n.

Return the maximum product of any two digits in n.

Note: You may use the same digit twice if it appears more than once in n.

Example 1:
Input: n = 31
Output: 3

Explanation:
    The digits of n are [3, 1].
    The possible products of any two digits are: 3 * 1 = 3.
    The maximum product is 3.

Example 2:
Input: n = 22
Output: 4

Explanation:
    The digits of n are [2, 2].
    The possible products of any two digits are: 2 * 2 = 4.
    The maximum product is 4.

Example 3:
Input: n = 124
Output: 8

Explanation:

    The digits of n are [1, 2, 4].
    The possible products of any two digits are: 1 * 2 = 2, 1 * 4 = 4, 2 * 4 = 8.
    The maximum product is 8.
*/

class Solution {
    public int maximumProductOfTwoDigits(int n) {
        char[] array = String.valueOf(n).toCharArray();     // take the number and convert it to a character array
        Arrays.sort(array);                                 // sort the characters by digit
        int largest = array[array.length - 1] - '0';        // biggest digit
        int secondLargest = array[array.length - 2] - '0';   // second biggest digit
        int result = largest * secondLargest;               // product of the top 2

        return result;
    }
}