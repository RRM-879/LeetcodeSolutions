class Solution {
    public int numberOfSpecialChars(String word) {
        // there are only 26 characters in the alphabet, 52 if we're searching for upper and lower case and seperating them both..

        // we can use a hashset to store all our characters
        HashSet<Character> charSet = new HashSet<>();

        // and a counter for our 'special' characters
        int specialCount = 0;

        // grab all the characters from the string and slap them into our set
        for(char c : word.toCharArray()) {
            charSet.add(c);
        }

        // because there is only 26 characters, we can just sequentially look like this
        for(char c = 'a'; c <= 'z'; c++) {
            // does our set contain this character AND it's uppercase version?
            if(charSet.contains(c) && charSet.contains((char) (c - 'a' + 'A')))
                specialCount++;
        }

        return specialCount;
    }
}