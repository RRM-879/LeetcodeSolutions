class Solution {
    public int largestAltitude(int[] gain) {
        // With this question.. we start at altitude of 0 and have to go through the array to find what the highest altitude is for the journey

        // we start at 0
        int highestAlt = 0;
        int journey = 0;
        // so as the biker goes through each point in gain
        for(int i = 0; i < gain.length; i++) {
            // add the value to our journey count
            journey += gain[i];

            // if the value at this point is bigger than our previous highest alt, swap it in
            if(journey > highestAlt) {
                highestAlt = journey;
            }
        }

        // return with the highest altitude value
        return highestAlt;
    }
}