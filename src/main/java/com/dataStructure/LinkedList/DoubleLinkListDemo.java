package com.dataStructure.LinkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:
 */
public class DoubleLinkListDemo {
    public static void main(String[] args) {

        // 创建节点对象
        DNode node01 = new DNode(1, "宋江", "及时雨");
        DNode node02 = new DNode(2, "卢俊义", "玉麒麟");
        DNode node03 = new DNode(3, "吴用", "智多星");
        DNode node04 = new DNode(4, "李逵", "黑旋风");

        // 添加节点
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addDoubleLinkedList(node01);
        doubleLinkedList.addDoubleLinkedList(node02);
        doubleLinkedList.addDoubleLinkedList(node03);
        doubleLinkedList.addDoubleLinkedList(node04);

        // 正序打印
        System.out.println("正序打印");
        doubleLinkedList.showForWardDoubleList();
        System.out.println("------------------------------------------");

        // 逆序打印
        System.out.println("逆序打印");
        DNode lastNode = doubleLinkedList.getLastNode();
        doubleLinkedList.showReversalDoubleList(lastNode);
        System.out.println("------------------------------------------");
    }
}

/**
 * 创建双链表
 */
class DoubleLinkedList {
    // 初始化头节点
    private DNode headDoubleNode = new DNode(0, "", "");

    /**
     * 返回头节点
     */
    public DNode getHeadNode() {
        return headDoubleNode;
    }

    /**
     * 获取尾结点
     */
    public DNode getLastNode() {
        DNode temp = headDoubleNode;
        while (true) {
            if (temp.getNext() == null) {
                break;//尾节点
            }
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 遍历双向链表正序
     */
    public void showForWardDoubleList() {
        // 为空结束
        if (headDoubleNode.getNext() == null) {
            System.out.println("链表为空");
            return;
        }

        // 定义临时节点
        DNode tempNode = headDoubleNode.getNext();
        // 遍历
        while (tempNode != null) {
            // 输出
            System.out.println(tempNode);
            // 链表后移
            tempNode = tempNode.getNext();
            if (tempNode == null) {
                break;// 链表为空
            }
        }
    }

    /**
     * 遍历双向链表逆序
     */
    public void showReversalDoubleList(DNode lastNode) {
        // 为空结束
        if (lastNode.getPre() == null) {
            System.out.println("链表为空");
            return;
        }

        // 定义临时节点
        DNode tempNode = lastNode ;
        // 遍历
        while (tempNode != null) {
            // 输出
            System.out.println(tempNode);
            // 链表前移
            tempNode = tempNode.getPre();
            if (tempNode.getPre() == null) {
                break;// 链表为空
            }
        }
    }

    /**
     * 添加双链表
     */
    public void addDoubleLinkedList(DNode node) {
        DNode tempNode = headDoubleNode;

        // 遍历链表-找到最后
        while (true) {
            if (tempNode.getNext() == null) {
                break;
            }

            // 没有找到-后移
            tempNode = tempNode.getNext();
        }
        // 找到链表最后
        // 形成双向链表
        tempNode.setNext(node);
        node.setPre(tempNode);
    }
}

/**
 * 创建节点类
 */
@Getter
@Setter
class DNode {

    private int id;
    private String name;
    private String nickname;
    private DNode next;// 指向后一个节点
    private DNode pre;// 指向前一个节点

    // 构造器
    public DNode(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

//    @Override
//    public String toString() {
//        return "DNode{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", nickname='" + nickname + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "DNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}