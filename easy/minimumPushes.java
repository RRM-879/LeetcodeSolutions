class Solution {
    public int minimumPushes(String word) {
        // 8 keys on the phone to deal with 26 letters in the alphabet
        // so we can assign 8 of characters to deal with 1 push of a button each, 8 for 2, 8 for 3, etc

        // need the length of the word
        int length = word.length();

        // and how many of our 8 letter blocks fit into that word
        int letterBlocks = length / 8;

        // then we can just return the number of complete letter blocks and deal with the remainder using %
        return (letterBlocks * (letterBlocks + 1) * 4) + ((length % 8) * (letterBlocks + 1));
    }
}