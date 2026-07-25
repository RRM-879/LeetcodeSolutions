/* Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

*/
class Solution {
    public static int romanToInt(String s) {
        int totalSum = 0;           // total sum
        int length = s.length();    // length of the input roman number

        for (int i = 0; i < length; i++) {
            // grab the character and feed it into our handy numeral checker
            int current = checkValue(s.charAt(i));

            // the actual difficult bit; checking for lesser values at the next digit
            if (i + 1 < length && current < checkValue(s.charAt(i+1))) {
                // this is the subtraction case, ie numbers like 4 (IV) vs 5 (V)
                totalSum -= current;
            } else {
                // this is the additive normal case, ie 6 (VI) or 11 (XI)
                totalSum += current;
            }
        }

        return totalSum;
    }

    // Private method to contain the case switch for numeral lookup
    // better private since I have to use it multiple times instead of declaring it in the for loop x times like an idiot
    private static int checkValue(char numeral) {
        switch(numeral) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        // Test examples
        System.out.println(romanToInt("III"));      // Output: 3
        System.out.println(romanToInt("LVIII"));    // Output: 58
        System.out.println(romanToInt("MCMXCIV"));  // Output: 1994
        System.out.println(romanToInt("XLIX"));     // Output: 49
        System.out.println(romanToInt("CMXCIX"));   // Output: 999
        System.out.println(romanToInt("MDCLXVI"));  // Output: 1666
    }
}