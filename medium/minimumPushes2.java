class Solution {
    public int minimumPushes(String word) {
        // so, similar to  yesterdays - 26 letters on a whole english word string
        // 8 + 8 + 8 + 2
        // we can use a greedy frequency array implementation to map the most frequent to the first 8, second to the second, etc

        // grab our array
        int[] countArray = new int[26];

        // our total pushes
        int total = 0;
        int touchIteration = 0;


        // fill it up as necessary
        for(char c : word.toCharArray())
            countArray[c - 'a']++;      // ascii offset 'a'

        // 26 characters in the alphabet means it is essentially O(1)
        Arrays.sort(countArray);

        // sort sorts ascendingly so, negative
        for(int i = 25; i >= 0; i--) {
            // if the countArray[i] is zero then the rest is zero so we can break out
            if(countArray[i] == 0)
                break;

            // break it up into the telephone keypad
            total += countArray[i] * ((touchIteration / 8) + 1);
            touchIteration++;
        }

        // and return our total
        return total;
    }
}