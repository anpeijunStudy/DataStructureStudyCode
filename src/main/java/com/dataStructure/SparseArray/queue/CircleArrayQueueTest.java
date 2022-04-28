package com.dataStructure.SparseArray.queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:
 */
public class CircleArrayQueueTest {
    public static void main(String[] args) {
        // 创建队列
        CircleQueue arrayQueue = new CircleQueue(3);
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

class CircleQueue {
    private int maxSize;// 数组的最大容量-队列的最大容量
    private int front;// 指向队列头-指向队列的第一个元素初始值0
    private int rear;// 指向队列尾-指向队列的最后一个元素，空出一个位置，初始值0

    private int[] array;// 该数组用来存放数据-队列

    // 构造器
    public CircleQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        array = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    // 判断是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据
    public void addQueue(int data) {
        // 判断数据是否为满
        if (isFull()) {
            System.out.println("数据已满-不可添加");
            return;
        }
        // 直接添加数据
        array[rear] = data;
        // rear后移-考虑取模
        rear = (rear + 1) % maxSize;// 防止数组越界
    }

    // 取出数据
    // 获取队列的数据
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列为空-没有数组");
        }
        // 分析出是指向队列的第一个元素
        // 1-front对应的值保存到临时变量
        int temp = array[front];
        // 2-front后移-考虑取模
        front = (front + 1) % maxSize;// 防止越界
        // 3-返回临时变量
        return temp;
    }

    // 显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空-无数据");
            return;
        }
        // 遍历从front到rear的值
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
        }
    }

    // 求出当前队列有效个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

}