class Solution {
    public int smallestNumber(int n, int t) {
        // two ints, n and t
        // we have to find the smallest number that is greater than or equal to n, such that the product of it's digits is divisible by t

        // by looking at the constraints we're given, we know that this can be solved with simple brute force
        for(int i = n; ; i++) {
            int number = i;
            int product = 1;

            // if the input number is 0, the loop won't ever run
            if(i == 0) return 0;

            while(number > 0) {
                // so we'll pop the first digit off
                int remainder = number % 10;

                // check the product of digits
                product = product * remainder;

                // and update our current number
                number = number / 10;
            }

            // and finally check if the product is divisible by t
            if(product % t == 0){
                return i;
            }
        }
    }
}