class Solution {
    public int reverse(int x) {
        // so we basically have to reverse the digits of a signed integer
        // we could repeatedly extract the last digit and build a reversed number.. but doing that can cause an integer overflow, so we'll have to check first
        int reverse = 0;

        // so lets deconstruct the number
        while(x != 0) {
            // grab the last digit..
            int currentDigit = x % 10;

            // check for overflow...
            if((reverse > Integer.MAX_VALUE / 10) || (reverse < Integer.MIN_VALUE / 10))
                return 0;

            // update our reverse number and add the current digit
            reverse = (reverse * 10) + currentDigit;

            // and update our original number
            x = x / 10;
        }

        return reverse;
    }
}