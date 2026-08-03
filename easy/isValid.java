class Solution {
    public boolean isValid(String s) {
        // brackets must close in the correct order
        // [] () {}  ||  {()}
        // [(]) will not work

        // can use a stack implementation a la the hints
        // new to me so lets try it.
        Stack<Character> stack = new Stack<>();

        // so, for every character in our input string
        for(char c : s.toCharArray()) {
            // we check if it's an open bracket
            if(c == '(' || c == '[' || c == '{') {
                // and push it onto our stack
                stack.push(c);
            } else {
                // first check if the stack is empty, if it is and we're here, we return false

                // now we pop the top character to check
                char topChar = stack.pop();

                // we check c against our topChar and if they don't match, we know that the input string isn't valid
                if(c == ')' && topChar != '(') return false;
                if(c == '}' && topChar != '{') return false;
                if(c == ']' && topChar != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}