class Solution {
    public int maxIceCream(int[] costs, int coins) {
        /** So because I'm an idiot I skipped the part where we needed to do a COUNTING SORT... I  had to look it up.

         So the question contraints say that the costs of the ice cream bars go from 1 to 100 000, essentially. So lets try this using a freq array
         */
        // get us our array
        int[] frequencyOfCost = new int[100001];
        int answer = 0;

        // dump all the costs into their proper place
        for(int cost : costs) {
            frequencyOfCost[cost]++;
        }

        // let's go through our cost array and...
        for(int cost = 1; cost <= 100000; cost++) {
            // if there is no ice cream bars at the specific value, move on
            if(frequencyOfCost[cost] == 0) continue;

            // lets get the total number of ice cream bars we can buy at this cost value
            int amount = Math.min(frequencyOfCost[cost], coins / cost);

            // then add that number of ice cream bars to our total answer and subtract the cost of them from our coins
            answer += amount;
            coins -= amount * cost;

            // quick checkt to see if we have enough coins to continue
            if(coins < cost) break;
        }

        return answer;
    }
}