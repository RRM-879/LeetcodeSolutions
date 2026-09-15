class Solution {
    public int removeDuplicates(int[] nums) {
        // so this is similar to problem #27 which I tried before this one.. but essentially
        // we have an int array nums sorted semi-ascendingly.. remove in place elements such that each unique element is encountered once..
        // k is our unique number of elements and thats the number we return, meaning that they can just slice the array at [k-1]

        // update: after being away due to THINGS happening in life, this is my first question back
        // so immediately I can just tell I was wrong about the above - They don't want you to remove the duplicates
        // they want you to sort the uniques at the front of the array and they'll slice it in half basically once everything is where it needs to be
        // in the end we return the number of unique elements so they know where to slice the array

        // so the new strategy here is to use 2 pointers
        // i to hold the current number
        // j to where the replacement will occur

        // basic sanity check
        if(nums.length == 0) return 0;

        // i is our pointer to hold the place of the next unique element we find in the array
        // we start from 1 because nums[0] is always a unique number to begin with
        int i = 1;

        // j is our traversal and unique checker
        for(int j = 1; j < nums.length; j++) {
            // so is this current number unique?
            if(nums[j] != nums[i - 1]) {
                // it isn't, so we have to place the unique element at the i'th position and then increment for the next unique
                nums[i] = nums[j];
                i++;
            }
        }

        // once the loop is done we can just return i; since that will be the total number of unique numbers!
        return i;
    }
}