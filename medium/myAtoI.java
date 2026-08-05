class Solution {
    public int myAtoi(String s) {
        // we can everything that isn't a number 0-9, ' ', '+', '-'
        // skip leading 0's until non digits or end of string. if no numbers, return 0
        // round to Integer.MAX_VALUE or Integer.MIN_VALUE to prevent overflow

        // so we can do a string parsing approach..
        // ignore leading whitespace
        // determine the + or -
        // stop conversion with non numbers
        // handle overflow cases

        // take 3
        // grab our length..
        int length = s.length();

        // null and length check..
        if(length == 0 || s == null) return 0;

        // our traversal pointer..
        int i = 0;

        // handle the whitespace at the beginning
        while(i < length && s.charAt(i) == ' ') i++;

        // our checker for positive and negative
        boolean isNegative = false;

        // and how we handle it
        if(i < length)  {
            if(s.charAt(i) == '-') {
                isNegative = true;
                i++;
            } else if(s.charAt(i) == '+') {
                i++;
            }
        }

        int result = 0;

        // so check to make sure the character is within our digit boundaries
        while((i < length) && (s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
            // so we'll grab the current character, minus the '0' to convert it from '3' to 3
            int currentDigit = s.charAt(i) - '0';

            // check for overflow
            if(result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && currentDigit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // bump the current result and add the currentDigit
            result = (result * 10) + currentDigit;
            i++;
        }

        return isNegative ? -result : result;
    }
}