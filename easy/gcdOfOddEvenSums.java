class Solution {
    public int gcdOfOddEvenSums(int n) {
        // so with some math....
        // first n even numbers sum is n*(n+1)
        // first n odd numbers sum is  n*n

        int sumEven = n * (n + 1);
        int sumOdd = n * n;

        return sumEven - sumOdd;
    }
}