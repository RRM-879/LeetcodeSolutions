class Solution {
    public String smallestPalindrome(String s) {
        /**
         * So we know we're given a palindromic string.. which means its already sorted out in a palindrome when we receive it.
         * Since its already a palindrome.. we don't have to search the entire string and can only do half...
         * we can take for the final answer (front + middle + reverseFront)
         * lexicographically.. means earlier letters in the alphabet and if equal its the smaller string.. so we have to sort for the alphabet and for length
         *
         * so we should count the number of times every character appears, sort it for a to z..
         * if a character appears more than once, place it at the left most and right most portions of our answer + if 1 occurence remains it goes in the middle
         */

        // we'll need to be able to count the frequency with which each letter appears - 26 letters means an array of size 26
        int[] frequency = new int[26];

        // we'll need a leftside and a middle
        StringBuilder left = new StringBuilder();
        String middle = "";

        // so for every character in the string, we map it out into our frequency array
        for(char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        // for every letter in the alphabet
        for(int i = 0; i < 26; i++) {
            // and for every second occurence of the letter
            for(int j = 0; j < frequency[i] / 2; j++) {
                // we add it to our palindrome on the left side of our string
                left.append((char) ('a' + i));

                // If the mod of the number is 1 then it's an odd number of recurrences and is thus our middle character
                if((frequency[i] % 2) == 1) {
                    middle = String.valueOf((char) ('a' + i));
                }
            }
        }

        // the right side of a palindrome is just the reverse of the left
        String right = new StringBuilder(left).reverse().toString();

        // and so we construct our smallest palindrome: left + middle + right
        return left.toString() + middle + right;
    }
}