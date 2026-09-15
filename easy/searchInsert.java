class Solution {
    public int searchInsert(int[] nums, int target) {
        // so, we have a target number and a sorted array of unique ints
        // if the target exists in nums, return the index of it
        // if it doesn't, return the index where it would be inserted, in order
        // must be logn runtime
        // this smells like a binary search, so first attempt, lets try using that

        // so, lets initialize left and right
        // left is the left of the array at 0, right is the length - 1
        int left = 0;
        int right = nums.length - 1;

        // so while we're still searching...
        while(left <= right) {
            // lets find the midpoint of the binary search
            int middle = left + (right - left) / 2;

            // now if that middle is our target?
            if(nums[middle] == target) {
                // fantastic, return it
                return middle;
                // but if the midpoint is greater than our target..
            } else if(nums[middle] > target) {
                // gotta adjust since the target is then in the left side of the tree
                right = middle - 1;
            } else {
                // otherwise it's in the right
                left = middle + 1;
            }
        }

        // if the target is not in our list, then eventually left will be where it terminates the search
        return left;
    }
}