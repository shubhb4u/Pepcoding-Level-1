import java.util.Stack;

class minStack {
    
    // Created 2 stacks for minStack -
    Stack<Integer> st1;
    Stack<Integer> st2;
    int min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public minStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int val) {
        
        st1.push(val);
        if (st2.isEmpty() || val < min){
            st2.push(val);
            min = st2.peek();
        }
    }
    
    public void pop() {
        
        if (st2.peek().equals(st1.peek())) {
            st2.pop();
        }
        st1.pop();
    }
    
    public int top() {
        
        return st1.peek();
    }
    
    public int getMin() {
        
        return st2.peek();
    }
}

// Working solution using 2 stacks -
    
//    Stack<Integer> stack;
//    Stack<Integer> minStack;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        stack = new Stack<>();
//        minStack = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        if (minStack.isEmpty() || x <= minStack.peek()) {
//            minStack.push(x);
//        }
//    }
//
//    public void pop() {
//        if (stack.peek().equals(minStack.peek())) minStack.pop();
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return minStack.peek();
//    }
//}