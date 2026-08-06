class Solution {
    public int strStr(String haystack, String needle) {
        // using a brute force approach for this or easier substring locating is apparently easy and definitely not a solution that teaches you anything..
        // The comments say using a KMP implemenation is the approach de jure, so I'll try that
        // thanks to AbstractedAway for his visualization of the KMP algorithm - it honestly matched what I was thinking when I first starting to think on this
        // ie, if we know part of the needle was in the haystack, then why bother doing a full brute force bfs or whatever, when you can just cut the part
        // that you already KNOW to be irrelevant when you're searching

        // Going to try a more.. difficult approach and we'll see if works first of all

        // so the second part is actually executing the search now that we've got our helper method to build up our lps table
        // lets make sure we're not being fed an empty search
        if(needle.isEmpty()) return 0;

        // we'll use our handy private helper to make this
        int[] lps = buildYourLPS(needle);

        // haystackTrack here is to track our active progress across haystack
        int haystackTrack = 0;
        // .. and needleTrack is to do the same inside needle
        int needleTrack = 0;

        // so lets begin
        while(haystackTrack < haystack.length()) {
            // do these letters match?
            if(haystack.charAt(haystackTrack) == needle.charAt(needleTrack)) {
                // they do! so lets update our pointer by 1
                haystackTrack++;
                needleTrack++;
            }
            // is our pattern complete?
            if(needleTrack == needle.length()) {
                // then we have our matched sub string and can return it's starting index
                return haystackTrack - needleTrack;
            } else if(haystackTrack < haystack.length() && haystack.charAt(haystackTrack) != needle.charAt(needleTrack)) {
                // if we're here then we're mid-search and have found a mismatch mid.. matching
                if(needleTrack != 0) {
                    // if a partial match is broken... we have to use our lookup LPS table to shift our needletracker back to the last know valid prefix location
                    needleTrack = lps[needleTrack - 1];
                } else {
                    // since needleTrack is already at 0, the current character cannot match the start of our needle pattern, so we have to increment to the next
                    haystackTrack++;
                }
            }
        }
        // if we get here, we've found out that there is no needle in the provided haystack
        return -1;
    }

    // we'll make this private method first to help us build out our LPS as defined by the KMP algorithm
    private int[] buildYourLPS(String needle) {
        // we grab our length and make a new LPS table of that size
        int[] lps = new int[needle.length()];

        // we need to know the length of the matching chunks that we discover
        int matchingChunkLength = 0;

        int i = 1;

        // so lets loop through the string and compute us our table
        while(i < needle.length()) {
            // first we compare the character at i to the character at matchingChunkLength
            if(needle.charAt(i) == needle.charAt(matchingChunkLength)) {
                // if the characters match then we have...
                // increment our matching length
                matchingChunkLength++;
                // add that character to our table at i
                lps[i] = matchingChunkLength;
                // and push forward up the string
                i++;
            } else {
                // a mismatch occurs!
                // so as long as our longestmatch isn't 0
                if(matchingChunkLength != 0) {
                    // if a submatch exists, we don't reset matchingChunkLength to 0, we skip back to the last known length using our table
                    matchingChunkLength = lps[matchingChunkLength - 1];
                } else {
                    // if our matching length is 0...
                    // we have no valid segments left so we have to assign lps[i] to 0 and advance up the string
                    lps[i] = 0;
                    i++;
                }

            }
        }
        // this should be the completed lps table
        return lps;
    }
}