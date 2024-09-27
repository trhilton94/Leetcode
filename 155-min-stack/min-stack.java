class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    } // minStack
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } // if
    } // push
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        } // if
        stack.pop();
    } // pop
    
    public int top() {
        return stack.peek();
    } // top
    
    public int getMin() {
        return minStack.peek();
    } // getMin
} // MinStack

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */