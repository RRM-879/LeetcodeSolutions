class Solution {
    public int numOfStrings(String[] patterns, String word) {
        // our total counter
        int total = 0;

        // for every pattern substring we want to find
        for(String s : patterns) {
            if(word.contains(s))        // check if our target word contains it
                total++;                // increment our total count if it does
        }

        return total;
    }
}