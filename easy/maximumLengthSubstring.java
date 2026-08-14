class Solution {
    public int maximumLengthSubstring(String s) {
        // a pretty easy sliding window implementation

        // so we'll take a window
        Map<Character, Integer> counter = new HashMap<>();

        int i = 0;
        int result = 0;

        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            counter.put(c, counter.getOrDefault(c, 0) + 1);

            while(counter.get(c) > 2) {
                char left = s.charAt(i);
                counter.put(left, counter.get(left) - 1);
                i++;
            }
            result = Math.max(result, j - i + 1);
        }

        return result;
    }
}