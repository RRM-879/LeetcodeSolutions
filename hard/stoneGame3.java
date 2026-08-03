class Solution {
    public String stoneGameIII(int[] stoneValue) {
        // another stone game..
        // alice starts, bob follows, round robin
        // each player can take the first 1 to 3 stones and add their value to said player's score
        // highest score wins, ties can happen
        // optimal play

        // we can.. look at it like this at the end.. if the score is 0, it's a tie.. if it's positive, Alice wins - negative? bob wins
        // because they're playing optimally.. we can look at it from the pov of the current player and use the same methodology for both sides..
        // current player wants to gain points and minimize the points the next player can have, therefore only a "currentScore" is necessary

        // we'll need the length and a dynamic programming array
        int length = stoneValue.length;
        int[] dp = new int[length + 1];

        // we use a  bottom up approach because of how the game works.
        // by starting at the end of the array and working backwards we ensure we have access to all possible outcomes
        for(int i = length - 1; i >= 0; i--) {
            // we need an int to hold our maximum possible score this turn
            int maxScore = Integer.MIN_VALUE;
            // and one to hold the sum of the values of the stones this turn's player chooses
            int turnSum = 0;

            // a player can choose 1, 2, or 3 stones
            for(int j = 1; j <= 3; j++) {
                // if a player tries to take more stones than what remains in the pile, we break the loop
                if(i + j > length) break;

                // we grab the value of the stones chosen this turn
                turnSum += stoneValue[i + (j - 1)];

                // minimax resolution
                // turnSum - dp[i + j] is our relative net advantage for the current player
                // our greedy solution between our current maxScore and the relative net for the current player
                maxScore = Math.max(maxScore, turnSum - dp[i + j]);
            }
            // and now we pop that max score into our dp array for use
            dp[i] = maxScore;
        }

        // if we've done this correctly, dp[0] will hold the maximum relative score value
        if(dp[0] > 0) return "Alice";       // if it's > 0 then "Alice" will win
        else if(dp[0] < 0) return "Bob";    // if it's < 0 then "Bob" will win
        else return "Tie";                  // obviously otherwise it's a "Tie"

    }
}