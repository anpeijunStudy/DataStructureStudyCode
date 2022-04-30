package com.dataStructure.stack;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:
 */
public class DoubleLinkedListStackDemo {
    public static void main(String[] args) {
// 创建节点
        Node node01 = new Node(1);
        Node node02 = new Node(2);
        Node node03 = new Node(3);
        Node node04 = new Node(4);
        Node node05 = new Node(5);

        // 添加节点
        DoubleLinkedListStack doubleLinkedListStack = new DoubleLinkedListStack(5);
        doubleLinkedListStack.push(node01);
        doubleLinkedListStack.push(node02);
        doubleLinkedListStack.push(node03);
        doubleLinkedListStack.push(node04);
        doubleLinkedListStack.push(node05);

        // 显示
        doubleLinkedListStack.showDoubleLinkedListStack();
    }
}

/**
 * 创建双链表栈
 */
class DoubleLinkedListStack {
    // 头节点
    private Node headNode = new Node(0);
    // 栈节点
    private Node topNode = headNode;// 总是指向最后一个节点
    private Integer maxSize;// 链表最大个数

    public DoubleLinkedListStack(Integer maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 压栈
     *
     * @param newNode 新的节点
     */
    public void push(Node newNode) {
        if (isFull()) {
            System.out.println("链表为满");
            return;
        }
        newNode.setNext(topNode.getNext());
        topNode.setNext(newNode);
        newNode.setPrev(topNode);
        topNode = topNode.getNext();
    }

    /**
     * 查看链表
     */
    public void showDoubleLinkedListStack() {
        Node temp = topNode;
        if (temp == headNode) {
            System.out.println("链表已空！");
            return;
        }
        while (temp != headNode) {
            System.out.println(temp);
            temp = temp.getPrev();
        }
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        if (headNode.getNext() == null) {
            return true;
        }
        return false;
    }

    /**
     * 栈满
     */
    public boolean isFull() {
        if (maxSize == DoubleLinkedListStackLength()) {
            System.out.println("链表满");
            return true;
        }
        return false;
    }

    /**
     * 计算链表的长度
     */
    public Integer DoubleLinkedListStackLength() {

        Node tempNode = headNode.getNext();

        Integer size = 0;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.getNext();
        }
        return size;
    }
}

/**
 * 创建节点
 */
@Setter
@Getter
class Node {
    private Integer id;
    private Node next;// 指向下一个节点
    private Node prev;// 指向上一个节点

    public Node(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}