class Solution {
    public int removeElement(int[] nums, int val) {
        // via the hints, we can move swap the occurences of val to the end of the array and swap that number back to val's place..
        // we need to return an int but also have to modify the array..

        // 1st and 2nd tries were heavily overthinking with pseudo sliding windows - althought I think the approach is still correct with 2 pointers
        // I just did too much and overthought the problem
        // 3rd try

        // this is our index, it is keeping track of the next slot where a number != to val should be placed
        // it also doubles as our counter for !val numbers, since once its done with swapping its on the last !val number anyway
        int index = 0;

        // i is our scanning pointer, to look for val's
        for(int i = 0; i < nums.length; i++) {
            // so if we find a number that isn't == to val and therefor safe to keep..
            if(nums[i] != val) {
                // we overwrite the value
                nums[index] = nums[i];
                // and move our index pointer up the array by one
                index++;
            }
        }
        // as said, at the end this should contain the number of !val numbers in the input array
        return index;
    }
}