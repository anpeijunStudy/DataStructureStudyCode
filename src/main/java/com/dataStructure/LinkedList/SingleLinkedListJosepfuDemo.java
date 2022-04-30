package com.dataStructure.LinkedList;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 安珮军
 * @version 1.0
 * @Description:
 */
public class SingleLinkedListJosepfuDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        // 添加
        circleSingleLinkedList.addBoy(5);
        // 遍历
//        circleSingleLinkedList.showCircleSingleLinkedList();
        // 出圈
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

/**
 * 创建环形链表
 */
class CircleSingleLinkedList {
    // 创建first节点-当前不赋值
    private Boy first = new Boy();

    // 添加节点-构成环形链表
    public void addBoy(int nums) {
        // 数据校验
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        // 辅助节点-帮助构建环形链表
        Boy tempNode = null;
        // 创建环形列表
        for (int i = 1; i <= nums; i++) {
            // 根据编号-创建节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setBoy(first);// 构建环形
                tempNode = first;
            } else {
                tempNode.setBoy(boy);
                boy.setBoy(first);
                tempNode = boy;
            }
        }
    }

    /**
     * 遍历环形链表
     */
    public void showCircleSingleLinkedList() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        // 辅助指针
        Boy tempNode = first;
        while (true) {
            System.out.println("编号：" + tempNode.getId());
            // 遍历完毕
            if (tempNode.getBoy() == first) {
                break;
            }
            tempNode = tempNode.getBoy();// 后移
        }
    }

    /**
     * 问题解决
     *
     * @param startID  开始数
     * @param countNum 数几下
     * @param nums     一共有多少
     */
    public void countBoy(int startID, int countNum, int nums) {
        // 数据校验
        if (first == null || startID < 1 || startID > nums || countNum < 1) {
            System.out.println("参数输入有误");
            return;
        }
        // 辅助节点
        Boy tempNode = first;
        while (true) {
            // 指向最后一个节点
            if (tempNode.getBoy() == first) {
                break;
            }
            tempNode = tempNode.getBoy();// 后移
        }
        // 小孩报数之前，先让first和tempNode移动k-1次
        for (int i = 0; i < startID - 1; i++) {
            first = first.getBoy();
            tempNode = tempNode.getBoy();
        }
        // 报数移动移动m-1次
        while (true) {
            // 剩余一个节点
            if (tempNode == first) {
                break;
            }
            // 让first和tempNode移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getBoy();
                tempNode = tempNode.getBoy();
            }
            // first指向的就是要出去的节点
            System.out.println("出圈编号：" + first.getId());
            // 删除节点
            first = first.getBoy();
            tempNode.setBoy(first);
        }
        System.out.println("最后编号：" + first.getId());
    }
}

/**
 * 创建Boy表示节点
 */
@Getter
@Setter
class Boy {
    private Integer id;
    private Boy boy;// 指向下一个节点

    // 构造器
    public Boy(Integer id) {
        this.id = id;
    }

    public Boy() {
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}