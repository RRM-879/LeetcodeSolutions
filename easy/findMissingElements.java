class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // we can use a hashset to track which numbers are in the provided array
        // and we still need to figure out what are minimum value and maximum value are

        // we need to initialize these to mx and min for min and max to make sure that they find *any* number instead of assuming the constraints hold
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // create our hashset of ints..
        Set<Integer> presentNumbers = new HashSet<>();

        List<Integer> missingNumbers = new ArrayList<>();

        // so lets populate our present numbers set with every number in the array as well as find our min and max values
        for(int i : nums) {
            if(i < min) min = i;
            if(i > max) max = i;
            presentNumbers.add(i);
        }

        // and we iterate through the range from min to max
        for(int i = min; i <= max; i++) {
            // and search for if this number i is in our present numbers set.
            if(!presentNumbers.contains(i))
                missingNumbers.add(i);      // naturally if it isn't, we add it to our List
        }

        // once we're here, we have our list, even if it's empty.
        return missingNumbers;
    }
}