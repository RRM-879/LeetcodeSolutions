class Solution {
    public int maxNumberOfBalloons(String text) {
        /**
         This question feels a bit tricky but we can use some frequency counting to get what we need
         Balloon
         1 B
         1 A
         2 L
         2 O
         1 N

         So we need to count these out by those numbers in our given String
         Since L and O need double we can effectively use freq(o)/2

         freq(b), freq(a), freq(l)/2, freq(o)/2, freq(n)
         */

        // so we initialize our counters
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;

        // and iterate the string for every character
        for(char c : text.toCharArray())
        {
            // we don't care about characters that are not in 'balloon'
            switch(c) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }

        // with the magic of Math.min, we can just return with a nested min comparison statement
        return Math.min(Math.min(b, a), Math.min(Math.min(l/2, o/2), n));
    }
}