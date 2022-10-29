class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                make(stack, numStack);
                continue;
            } else if (c == '[') {
                numStack.push(num(stack));
            }
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int num(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
            sb.append(stack.pop());
        }
        return Integer.valueOf(sb.reverse().toString());
    }

    public void make(Stack<Character> stack, Stack<Integer> numStack) {
        int num = numStack.pop();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.peek() != '[') {
            sb.append(stack.pop());
        }

        stack.pop(); // '[' remove

        String repeat = sb.reverse().toString().repeat(num);

        for (char c : repeat.toCharArray()) {
            stack.push(c);
        }
    }
}