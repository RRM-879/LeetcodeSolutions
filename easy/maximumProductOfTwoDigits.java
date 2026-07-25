class Solution {
    public int maximumProductOfTwoDigits(int n) {
        char[] array = String.valueOf(n).toCharArray();     // take the number and convert it to a character array
        Arrays.sort(array);                                 // sort the characters by digit
        int largest = array[array.length - 1] - '0';        // biggest digit
        int secondLargest = array[array.length - 2] - '0';   // second biggest digit
        int result = largest * secondLargest;               // product of the top 2

        return result;
    }
}