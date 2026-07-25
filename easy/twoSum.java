/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // We'll try a hashmap based solution here - had to look up Java implementation, again
        Map<Integer, Integer> numberMap = new HashMap<>();

        // We iterate along the length
        for(int i = 0; i < nums.length; i++) {
            /**
             * and we look for a complementary number such that if the target is 5 and i is 1
             * we do 5 - 1 and look for a key on the hash map that is 4, since we know the exact sum
             * we can use it in this way to check for what we want
             */
            int complement = target - nums[i];

            // check the hash map for the target key
            if(numberMap.containsKey(complement)) {
                return new int[]{numberMap.get(complement), i};
            }

            numberMap.put(nums[i], i);
        }

        // No solution eventuality
        return new int[]{};
    }
}