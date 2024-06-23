package date04;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;
    /**
     * 创建两个栈
     */
    public MyQueue() {
//        压入栈
        s1=new Stack<>();
//        输出栈
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s2.empty()){
//            输出栈为空则把输入栈所有的元素压入输出栈
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(s2.empty()){
//            输出栈为空则把输入栈所有的元素压入输出栈
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}
