class Solution {
    public int lengthOfLastWord(String s) {
        // so we're given a long string of words joined by underscores: one_two_three_four, etc
        // a word is a maximalsubstring consisten of non-space characters only...

        // so we shouldddd be able to go backwards right?
        /*int length = s.length();

        if(s == null) return 0;
        if(length == 1) return 1;

        for(int i = (length - 1); i > 0; i--) {
            if(s.charAt(i) == ' ') {
                return (length - 1) - i;
            }
        } */

        // So after dealing with a thing - I've been overthinking this and working around problems instead of axing through them

        // we trim the string of trailing whitespaces
        s = s.trim();

        // still need our length of the last word
        int length = 0;

        // still can work backwards since it's the LAST word
        for(int i = (s.length() - 1); i >= 0; i--) {
            // so if our character here is not blank we've found our last word and can increment it
            if(s.charAt(i) != ' ')
                length++;
                // otherwise if we're handling a blankspace and our length is > 0, we're got our complete word and can break the loop
            else if(length > 0)
                break;
        }

        // for the event in which we completely finish the loop, we can just return length
        return length;
    }
}