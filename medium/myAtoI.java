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

        // so lets start by trimming the input string to remove whitespace at the start
        s = s.trim();

        // our sign, we presume positive and just check for negative
        int sign = 1;

        // our traversal variable..
        int i = 0;

        // our result variable to hold the number
        int result = 0;

        // make sure 0 length strings are taken care of...
        if(s.length() == 0)
            return 0;

        // check for + or -
        if(s.charAt(0) == '-') {
            // so we know it's a negative number and can increment our traversal
            sign = -1;
            i++;
        } else if(s.charAt(0) == '+') {
            i++;
        }

        // time to deal with the rest of the numbers
        while(i < s.length()) {
            // so lets grab the character..
            char c = s.charAt(i);

            // use character comparison to make sure it's in our valid numerical bounds
            if(c < '0' || c > '9') break;

            // convert that character to a number
            result = (result * 10) + (c - '0');

            // deal with the overflow cases
            if(sign * result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign * result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            // increment our counter and move on the loop
            i++;
        }

        // have to cast it to an int multiplied buy our sign!
        return (int) (sign * result);
    }
}