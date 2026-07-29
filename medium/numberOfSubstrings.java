class Solution {
    public int numberOfSubstrings(String s) {
        // we can use a sliding window method here as well, so lets try it
        // so we'll need our mapped window for A B C
        int[] charCounter = new int[3];

        // our left and right sides of it
        int left = 0;
        int right = 0;

        // and our total counter for the number of substrings
        int total = 0;

        // moving down the right side of the window
        for(right = 0; right < s.length(); right++) {
            // add the character to our frequency map
            charCounter[s.charAt(right) - 'a']++;

            // check if the count for our letters matches our abc necessity
            while(charCounter[0] > 0 && charCounter[1] > 0 && charCounter[2] > 0) {
                // if we're here we've found a substring that matches!
                // so increment the total amount by whats left in the length - right, to get our total extra occurences so we don't have to count manually
                total += s.length() - right;
                // then remove the left most character
                charCounter[s.charAt(left) - 'a']--;
                // and move the left window up
                left++;
            }
        }

        return total;
    }
}