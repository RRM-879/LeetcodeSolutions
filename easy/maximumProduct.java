/**
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 6
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 24
 *
 * Example 3:
 * Input: nums = [-1,-2,-3]
 * Output: -6
 */

// first thought is to traverse the list & grab the 3 highest numbers and multiply them.. but we need to look at negative numbers too
// can sort the array, look at the first two if they're negative and the final - or the final 3.. far easier than searching and multiplying everything
class Solution {
    public int maximumProduct(int[] nums) {

        //sort the array
        Arrays.sort(nums);

        // make sure we can actually do the question
        if(nums.length < 3) {
            return 0;
        }

        // return the maximum of these two numbers
        // it's either 1st*2nd*last (negative*negative*positive) or last*2ndlast*3rdlast (pos*pos*pos or neg*neg*neg)
        return Math.max(((nums[0] * nums[1]) * nums[nums.length - 1]), (nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]));
    }
}