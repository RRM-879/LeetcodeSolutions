/** so we're given a grid of m x n dimensions and know that when the grid 'shifts'
 grid[i][j]               moves to grid[i][j+1]  - so this shifts it one to the right
 grid[i][width-1]         moves to grid[i+1][0]  - and this is for the far right column and pushes it to the next row
 grid[length-1][width-1]  moves to grid[0][0]    - and this is for the bottom right corner moving to top left

 1 2 3       9 1 2
 4 5 6       3 4 5
 7 8 9       6 7 8
 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // so to get started.. we have a list of lists of integers to represent a length and width of a 2d grid or matrix
        // we have to shift that grid K times given the shift instructions as defined..
        int numRows = grid.length;
        int numCols = grid[0].length;

        // We'll need an answer list so
        List<List<Integer>> answerList = new ArrayList<>();
        // gotta populate it
        for(int row = 0; row < numRows; row++) {
            // for every row we want to add a column and initialize it all to 0
            List<Integer> currentRow = new ArrayList<>();
            for(int column = 0; column < numCols; column++) {
                currentRow.add(0);
            }
            answerList.add(currentRow);
        }

        // we have to shift K times, so to make it easier on ourselves, we'll flatten the grid into a 1D array, which makes things infinitely easier
        for(int row = 0; row < numRows; row++) {
            for(int column = 0; column < numCols; column++) {
                // so we'll convert this 2D position to a 1D one
                // this part needed Dr. Google to help me understand
                // but by converting it to 1D, we can use modulus operators to help shift every elemental of the list
                // and we'll know exactly which elements wrap around back to the beginning of a new row after K shifts, its quite brilliant

                // so we grab our current spot in the grid; the row we're on, the total number of columns it has and add the current column we're working on
                int currentSpot = (row * numCols) + column;

                // then we take that current location and add the number of shifts we have to make to it
                // before modulusin' against our total number of elements
                int newSpot = (currentSpot + k) % (numRows * numCols);

                // after that we have to convert it back to our regular 2D grid system
                int newRow = newSpot / numCols;
                int newColumn = newSpot % numCols;

                // and toss them back into our answerList
                answerList.get(newRow).set(newColumn, grid[row][column]);
            }
        }
        // by the time our loops are done we've shifted the whole grid K times in only O(n*m) time
        return answerList;
    }
}