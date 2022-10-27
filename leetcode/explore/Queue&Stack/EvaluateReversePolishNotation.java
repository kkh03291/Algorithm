class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                cal(s, stack);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public void cal(String s, Stack<Integer> stack) {
        int first = stack.pop();
        int second = stack.pop();
        switch (s) {
            case "+":
                stack.push(second + first);
                break;
            case "-":
                stack.push(second - first);
                break;
            case "*":
                stack.push(second * first);
                break;
            case "/":
                stack.push(second / first);
                break;
            default :
                break;

        }
    }
}