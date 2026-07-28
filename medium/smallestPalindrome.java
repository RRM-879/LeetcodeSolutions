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
        // take 2

        int length = s.length();

        // ternary even/odd
        String middleCharacter = (length % 2 != 0)  // check
                ?  s.charAt(length / 2) + ""            // odd
                : "";                                   // even

        // since we only need a string to represent half the well, string
        StringBuilder half = new StringBuilder();
        // still need the alphabet count sort
        int[] alphabetTable = new int[26];

        // lets populate that alphabet table
        for(int i = 0; i < length / 2; i++) {
            alphabetTable[s.charAt(i) - 'a']++;
        }

        // and here we construct our answer string
        for(int i = 0; i < 26; i++) {
            // so we'll append and repeat for as many characters as we need
            half.append( ((char)(i + 'a') + "").repeat(alphabetTable[i]));
        }

        // and return the constructed half + the middle character + the reverse of the first half
        return half.toString() + middleCharacter + half.reverse().toString();

    }
}