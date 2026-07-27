/**
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */
class Solution {
    public int maxProduct(int[] nums) {
        // pretty simple question once you get over how badly worded the description of it is
        // given an array n, find the maximum product possible from the numbers within it

        // don't need anything fancy, it's O(n) to traverse the array once so
        int first = 0;
        int second = 0;

        // for every number in the array
        for (int num : nums) {
            // if the number is bigger than the first largest
            if (num > first) {
                // the second largest takes the previous first largest
                second = first;
                // and the first largest takes on the value of this new number
                first = num;
            } else if(num > second) {
                // if the number is bigger than the second largest, we swap that in
                second = num;
            }
        }
        // afterwards return the product
        return (first - 1) * (second - 1);
    }
}