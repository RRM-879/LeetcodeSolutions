/**
 So for this one we need to keep track of the largest number as well as the smallest.
 Finding the GCD in Java is a pain in the ass involving BigIntegers and things I haven't learned about yet, so instead lets focus on a different approach
 We can use the Euclidean algorithm and model it in to find exactly what we want
 */
class Solution {
    public int findGCD(int[] nums) {
        // lets initialize our minimum and maximum values
        int minimum = 1001;
        int maximum = 0;

        // and for every number in our number array, we search through it to update those values
        for(int num : nums) {
            if(num < minimum)
                minimum = num;
            if(num > maximum)
                maximum = num;
        }

        // then we can just make a private function to get the Euclidean algorithm rolling
        return gcd(minimum, maximum);
    }

    // a function such as this
    private int gcd(int a, int b) {
        // so while we have a non-zero remainder leftover
        while(b != 0) {
            // we find our new remainder
            int remainder = a % b;
            a = b;
            b = remainder;
        }

        // and return the largest GCD
        return a;
    }
}