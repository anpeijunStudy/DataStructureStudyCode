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
public class SingleLinkListDemo {
    public static void main(String[] args) {
        Node node01 = new Node(1, "宋江", "及时雨");
        Node node02 = new Node(2, "卢俊义", "玉麒麟");
        Node node03 = new Node(3, "吴用", "智多星");
        Node node04 = new Node(4, "李逵", "黑旋风");

        SingleLikedListNode singLeLInkedList = new SingleLikedListNode();
        // 不按顺序添加节点
//        singLeLInkedList.addNode(heroNode01);
//        singLeLInkedList.addNode(heroNode02);
//        singLeLInkedList.addNode(heroNode03);

        // 按照顺序添加
        singLeLInkedList.addOrderNode(node01);
        singLeLInkedList.addOrderNode(node04);
        singLeLInkedList.addOrderNode(node03);
        singLeLInkedList.addOrderNode(node02);

        // 修改节点
        Node node04Update = new Node(4, "李鬼", "假黑旋风");
        singLeLInkedList.updateNode(node04Update);

        // 删除节点
//        singLeLInkedList.deleteNode(4);

        // 查找倒数节点
        int reciprocalNumber = 2;
        Node reciprocalNode = singLeLInkedList.findReciprocalNode(reciprocalNumber);
        System.out.println("倒数第" + reciprocalNumber + "节点" + reciprocalNode);

        // 链表反转
        singLeLInkedList.reversalNode();

        // 显示所有节点
        singLeLInkedList.showList();

        // 计算节点个数
        System.out.println("节点的个数=" + singLeLInkedList.validNumberNode());

    }
}

/**
 * 创建单链表 管理节点
 */
class SingleLikedListNode {
    // 初始化节点，头节点不可以动
    private Node headNode = new Node(0, "", "");

    /**
     * 添加节点
     *
     * @DeDescription 找到节点的最后节点-最后节点的next指向新的节点
     */
    public void addNode(Node node) {
        // head节点不可以动，因此需要一个辅助节点
        Node tempNode = headNode;
        // 遍历链表-找到最后的节点
        while (true) {
            // 链表的最后
            if (tempNode.getNext() == null) {
                break;
            }
            // 没有找到最后的节点-再次进行循环
            tempNode = tempNode.getNext();
        }
        // 退出循环-tempNode指向的是最后的节点
        tempNode.setNext(node);
    }

    /**
     * 显示链表
     */
    public void showList() {
        // 判断链表是否为空
        if (headNode.getNext() == null) {
            System.out.println("链表不可以为空");
            return;
        }
        // head节点不可以动，因此需要一个辅助节点
        Node tempNode = headNode.getNext();
        // 遍历链表-找到最后的节点
        while (true) {
            // 链表的最后
            if (tempNode == null) {
                break;
            }
            // 输出节点
            System.out.println(tempNode);
            // 后移
            tempNode = tempNode.getNext();
        }
    }

    /**
     * 按照顺序来添加节点-有相同节点提示
     */
    public void addOrderNode(Node node) {
        // head节点不可以动，因此需要一个辅助节点tempNode
        // temp是位于添加位置的前一个节点，否侧插入不了
        Node tempNode = headNode;
        boolean flag = false;// 判断添加的节点是否存在，默认false不存在
        // 遍历链表-找到最后的节点
        while (true) {
            // 链表的最后
            if (tempNode.getNext() == null) {
                break;
            }
            if (tempNode.getNext().getId() > node.getId()) {// 位置节点找见
                break;
            } else if (tempNode.getNext().getId() == node.getId()) {// 位置节点存在
                flag = true;
                break;
            }
            // 没有找到位置节点-再次进行循环
            tempNode = tempNode.getNext();
        }
        if (flag == true) {
            System.out.println("准备插入的" + node.getId() + "已经存在");
        } else {
            // 插入到链表中-tempNode的后面
            node.setNext(tempNode.getNext());// 相当于tempNode后面节点的插入node的后面
            tempNode.setNext(node);// 再将node插入到找到的节点的后面
        }
    }

    /**
     * 修改链表节点
     */
    public void updateNode(Node node) {
        // 判断节点是否为空
        if (headNode.getNext() == null) {
            return;
        }
        // 辅助节点
        Node tempNode = headNode.getNext();
        // 遍历节点
        while (true) {
            // 判断是否是最后一个节点
            if (tempNode == null) {
                System.out.println("输入有误-没有节点");
                break;
            }
            if (tempNode.getId() == node.getId()) {// 找到修改的节点
                break;
            }
            // 没有找到-后移
            tempNode = tempNode.getNext();
        }
        tempNode.setName(node.getName());
        tempNode.setNickname(node.getNickname());
    }

    /**
     * 删除链表节点
     * <p>
     * 相当于使-删除的节点-后面的节点-指向要删除节点-前面的节点
     */
    public void deleteNode(int id) {
        Node temp = headNode;
        boolean flag = false;// 表示是否找见要待删除的节点

        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getId() == id) {// 找到待删除的节点的前一个节点
                flag = true;
                break;
            }

            temp = temp.getNext();// temp后移
        }
        // 判断flag
        if (flag == true) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("没有节点" + id);
        }
    }

    /**
     * 获取有效节点的个数
     */
    public int validNumberNode() {
        Node tempNode = headNode;
        int nodeNumber = 0;
        while (true) {
            if (tempNode.getNext() == null) {// 为空跳出
                break;
            }
            nodeNumber++;
            tempNode = tempNode.getNext();// tempNode后移
        }
        return nodeNumber;
    }

    /**
     * 查找单链表中的倒数第K个节点
     * <p>
     * 1. 编写一个方法，接收 head节点，同时接收一个 index
     * 2. index 表示是倒数第 index 个节点
     * 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
     * 4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
     * 5. 如果找到了，则返回该节点，否则返回 nul
     */
    public Node findReciprocalNode(int index) {
        // 链表为空-返回null
        if (headNode.getNext() == null) {
            return null;
        }

        // 遍历-链表的长度
        Integer nodeSize = validNumberNode();

        // 遍历nodeSize-index就是倒数节点

        // 1-校验
        if (index <= 0 || index > nodeSize) {
            return null;// 查找的节点小于0或者大于链表的长度
        }
        // 辅助变量-for循环定位
        Node tempNode = headNode.getNext();
        for (int i = 0; i < nodeSize - index; i++) {
            tempNode = tempNode.getNext();// 后移节点
        }
        return tempNode;
    }

    /**
     * 反转链表
     * <p>
     * 1-先定义一个节点reversalNode= new Node();
     * 2-从头遍历链表-每遍历一个节点，就将其放在新的链表的最前端
     * 3-headNode.next()=reverseNode.next()
     */
    public void reversalNode() {
        // 为空或者只有一个节点
        if (headNode.getNext() == null || headNode.getNext().getNext() == null) {
            return;
        }

        // 辅助节点
        Node tempNode = headNode.getNext();
        Node nextNode = null;// 指向当前的节点(tempNode)的下一个节点,不然链表会断掉
        Node reversalNode = new Node(0, "", "");// 反转头节点

        // 遍历原来的链表
        // 从头遍历链表-每遍历一个节点，就将其放在新的链表(reversalNode)的最前端
        while (tempNode != null) {
            nextNode = tempNode.getNext();//保留tempNode的下一个节点
            tempNode.setNext(reversalNode.getNext());// 将temp的头节点指向新链表的前面
            reversalNode.setNext(tempNode);// 将tempNode连接
            tempNode = nextNode;// tempNode后移
        }

        // 连接-链表反转
        headNode.setNext(reversalNode.getNext());
    }

    /**
     * 逆序打印
     * <p>
     * 可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的特点
     */
    public void reversalPrintNode() {
    }


}

/**
 * 创建节点，用来真正存放数据的
 * 每个Node对象就是一个节点
 */
@Getter
@Setter
class Node {
    private int id;
    private String name;
    private String nickname;
    private Node next;

    public Node(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}