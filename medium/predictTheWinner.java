class Solution {
    public boolean predictTheWinner(int[] nums) {
        // so.. this one is abstract for me
        // they both play optimally, so that makes it easier on us..
        // each turn they choose between nums[0] or nums[length-1]; first or last in the array
        // goal is to minimize the total value of the cards in your hand
        // but since player 1 always go first.. if there is an EVEN number of 'cards' or elements in the array.. player 1 can always at LEAST win

        // also.. why bother keeping track of scores for both players when you can keep track of the difference between them
        // if you're positive, they're negative

        int length = nums.length;
        if(length % 2 == 0)     // if it's even player 1 can always at least win or tie because of round robin turns, p1 can control what p2 picks thus forcing it
            return true;

        // we clone the array and keep it 1D instead of 2D because we're keeping track of the DIFFERENCE and not calculating value at every i,j
        int[] clone = nums.clone();

        // starting index -- think of it as a sort of reverse moving sliding window
        for(int i = length - 2; i >= 0; i--) {
            // right index just to the right of our start
            for(int j = i + 1; j < length; j++) {

                // nums[i] - clone[j] is what our opponent will play optimally
                // nums[j] - clone[j - 1] is what our net gain will be
                clone[j] = Math.max(nums[i] - clone[j], nums[j] - clone[j - 1]);
            }
        }

        // now clone @ length-1 contains the difference, so if it's >= 0 player 1 can win
        return clone[length - 1] >= 0;
    }
}