package com.dataStructure.stack;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        // 添加
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);

        // 出栈
        System.out.println("出栈");
        System.out.println(arrayStack.pop());
        System.out.println("-------------------");
        // 遍历
        System.out.println("遍历");
        arrayStack.show();
        System.out.println("-------------------");
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

    /**
     * 入栈
     */
    public void push(int value) {
        // 首先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop() {
        // 判断是否为空
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("栈空-没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]" + "的数据是：" + stack[i]);
        }
    }
}