class Solution {
    public long sumAndMultiply(int n) {
        // so for this we need to iterate over the digits in n
        // skip the digits with '0', build up a smaller int by appending the non-zero digits
        // construct the sum of those digits as we go
        // and return newNum * sum

        long newNum = 0;
        long sum = 0;

        // grab the number, convert to a character array for easy iteration
        for(char c : String.valueOf(n).toCharArray()) {
            // if this digit isn't a zero
            if(c != '0') {
                // we append the digit to our newNum aka x
                newNum = newNum * 10 + c - '0';
                // and increment our sum
                sum += c - '0';
            }
        }

        return newNum * sum;
    }
}