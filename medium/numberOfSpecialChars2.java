class Solution {
    public int numberOfSpecialChars(String word) {
        // first thought - copy solution from 1 and adapt it
        // more I think, less I think it will work butttt
        // what if we get two maps and slap uppers in one and lowers in the other and then check both <- didn't work the way I wanted
        // INSTEAD, after struggling a while, why not just make 2 maps and keep note of the last time every lower and upper case character is seen?


        // so we'll map our two arrays for upper/lower
        int[] mapLower = new int[26];
        int[] mapUpper = new int[26];
        int length = word.length();

        // I struggled a lot with filling the arrays off the bat but in the end..
        Arrays.fill(mapLower, -1);
        Arrays.fill(mapUpper, -1);

        // so as we go along the string
        for(int i = 0; i < length; i++) {
            // we grab the character for the current index of i
            Character c = word.charAt(i);

            // and check if it's lowercase
            if(Character.isLowerCase(c)) {
                // if it is, we add it to our reference array!
                mapLower[c - 'a'] = i;
            } else {
                // if we're here it's an Uppercase
                int j = c - 'A';
                // if we haven't seen an upper of this letter before
                if(mapUpper[j] == -1 )
                    mapUpper[j] = i;            // change it's reference!
            }
        }

        // now that we've sorted out our reference maps...
        int answer = 0;
        // go down the maps
        for(int i = 0; i < 26; i++) {
            // if the lower and upper maps have a reference point (!= -1)
            // AND the lower map reference point is BEFORE the upper for that same letter..
            if(mapLower[i] != -1 && mapUpper[i] != -1 && mapLower[i] < mapUpper[i])
                answer++;       // we got a special character here..
        }

        return answer;
    }
}