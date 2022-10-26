class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ')') {
                if (stack.size() == 0) return false;
                // char tmp = stack.peek();
                if (stack.peek() == '(') stack.pop();
                else return false;
                continue;
            }

            if (c == '}') {
                if (stack.size() == 0) return false;
                // char tmp = stack.peek();
                if (stack.peek() == '{') stack.pop();
                else return false;
                continue;
            }

            if (c == ']') {
                if (stack.size() == 0) return false;
                // char tmp = stack.peek();
                if (stack.peek() == '[') stack.pop();
                else return false;
                continue;
            }
            stack.push(c);
            // System.out.println(stack.peek());
        }
        if (stack.size() != 0) return false;
        return true;
    }
}