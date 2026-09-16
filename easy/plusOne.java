class Solution {
    public int[] plusOne(int[] digits) {
        // so this is an addition problem
        // we're given an array of digits [1, 2, 3]
        // so have to add 1
        // [1, 2, 3] becomes [1, 2, 4]
        // but so does [9] become [1, 0]

        // so we have to think about 3 cases with this problem
        // What if all the values are 9?
        // What if the last digit isn't 9?
        // what if the last digit is 9

        // so what we can do is- check the value at the index
        // if if a value is 9 we have to 0 it and carry the one, so we go to the previous index and update it by 1
        // if they're all 9 as in '9999'
        // then we have to create a new array, add 1 to the first index and 0 the rest.

        // so lets work back to front
        for(int i = (digits.length - 1); i >= 0; i--){
            // if the digit is less than 9, we dont need to carry so
            if((digits[i] + 1) != 10) {
                // we just add the digit and return the new array
                digits[i] += 1;
                return digits;
            }
            // if digits[i] + 1 == 10, we need to zero the value
            digits[i] = 0;
        }

        // and make a new array of 1 size larger
        int[] answer = new int[digits.length + 1];
        // then add our 1 as the first digit
        answer[0] = 1;
        return answer;
    }
}