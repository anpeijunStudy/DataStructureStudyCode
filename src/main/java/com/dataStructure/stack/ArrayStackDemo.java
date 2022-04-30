package com.dataStructure.stack;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

/**
 * 定义一个ArrayStack表示栈
 */
class ArrayStack {
    // 栈的大小
    private int maxSize;
    // 存放实际数据
    private int[] stack;
    // 初始化为-1，表示栈顶
    private int top = -1;

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;

    }
}