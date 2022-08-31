import java.util.Stack;

class minStack {
    
    // Created 2 stacks -
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int min = Integer.MAX_VALUE;
    
    public void push(int val) {
        
        st1.push(val);
        if (st2.isEmpty() || val < min){
            st2.push(val);
            min = st2.peek();
        }
    }
    
    public void pop() {
        
        if (min == st1.peek()) {
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