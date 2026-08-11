class Solution {
    public int missingInteger(int[] nums) {
        // so starting from the first element, we can keep addding more elements as long as they are +1 from the previous, simple right?
        // so 3, 4, 5, 17, 8, 54, 20
        // the sum of the prefix is 3+4+5 == 12
        // now we need to find the smallest missing integer that is at least == sum
        // in this example we take sum and increase it by 1 until we find a value, 13

        // A hashset seems pretty great for this so lets try that style of implementation

        // we'll take our length and make a new hashset with that length..
        int length = nums.length;
        Set<Integer> checked = new HashSet<>(length);
        // populate the set..
        for(int i : nums){
            checked.add(i);
        }
        // grab our starting sum, which is just the first number in the array
        int sum = nums[0];

        // need to find our sequential prefix sum
        for(int i = 1; i < length; i++) {
            if(nums[i] == nums[i - 1] + 1)
                sum += nums[i];
            else break;
        }

        // starting from the sum, we check if that value exists in the set
        // and increment by 1 until we find it
        while(checked.contains(sum))
            sum++;

        return sum;
    }
}