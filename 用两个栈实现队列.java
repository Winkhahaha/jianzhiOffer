package 剑指金钱;

import java.util.Stack;

public class 用两个栈实现队列 {

	public static void main(String[] args) {

	}

}
 class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);	// 3 -> 2 -> 1
    }
    
    public int pop() {
    	if(stack2.isEmpty()) {
    		while(!stack1.isEmpty()) {	
    			stack2.push(stack1.pop());	// 1 -> 2 -> 3
    		}
    	}
		return stack2.pop();		// 1,2,3
    
    }
}
