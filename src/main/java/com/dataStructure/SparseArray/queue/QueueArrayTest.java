package com.dataStructure.SparseArray.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:队列模拟-数组实现
 */
public class QueueArrayTest {
    public static void main(String[] args) {
        // 创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //使用
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("1(show): 显示队列");
            System.out.println("2(exit): 退出程序");
            System.out.println("3(add): 添加数据到队列");
            System.out.println("4(get): 从队列取出数据");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    arrayQueue.showQueue();
                    break;
                case 2:
                    System.exit(0);
                    break;
                case 3:
                    System.out.println("请输入你要添加的数据");
                    int nextInt = scanner.nextInt();
                    arrayQueue.addQueue(nextInt);
                    arrayQueue.showQueue();
                    break;
                case 4:
                    System.out.println(arrayQueue.getQueue());
                    arrayQueue.showQueue();
                    break;
            }
        }
    }
}

// 使用数组模拟队列-编写一个类
class ArrayQueue {

    private int maxSize;// 数组的最大容量-队列的最大容量
    private int front;// 指向队列头
    private int rear;// 指向队列尾

    private int[] array;// 该数组用来存放数据-队列

    // 创建队列构造器

    public ArrayQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        this.front = -1;// 指向队列头部-指向的是队列头的前一个位置
        this.rear = -1;// 指向队列尾部-具体的队列尾部数据位置
    }

    // 判断队列是否是满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否是空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int data) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列已满-不可添加");
            return;
        }
        rear++;// 指向位置加一（-1到0，刚好数数组的最小下标）
        System.out.println(rear);
        array[rear] = data;// 加入数据
    }

    // 获取队列的数据
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列为空-没有数组");
        }
        front++;
        return array[front];
    }

    // 显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空-无数据");
            return;
        }
        System.out.println(Arrays.toString(array));
    }
}