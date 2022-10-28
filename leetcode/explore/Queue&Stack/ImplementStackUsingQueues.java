class MyStack {
    Queue<Integer> input;
    Queue<Integer> tmp;

    public MyStack() {
        input = new LinkedList<>();
        tmp = new LinkedList<>();
    }

    public void push(int x) {
        if (input.isEmpty()) {
            input.offer(x);
            return;
        }
        while(!input.isEmpty()) {
            tmp.offer(input.poll());
        }
        input.offer(x);
        while(!tmp.isEmpty()) {
            input.offer(tmp.poll());
        }
    }

    public int pop() {
        return input.poll();
    }

    public int top() {
        return input.peek();
    }

    public boolean empty() {
        return input.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */