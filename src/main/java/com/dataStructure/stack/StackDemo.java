package com.dataStructure.stack;

import java.util.Stack;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        // 入栈
        stack.add("A");
        stack.add("B");
        stack.add("C");
        stack.add("D");
        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
