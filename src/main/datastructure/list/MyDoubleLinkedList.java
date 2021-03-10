package main.datastructure.list;

/**
 * 双向链表
 *
 * @author LinKai
 * @time 2020/9/14-21:16
 */
public class MyDoubleLinkedList {

    /**
     * 头
     */
    private DoubleNode head;

    /**
     * 尾
     */
    private DoubleNode tail;

    /**
     * 构造方法
     */
    MyDoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 往头部插入数据
     *
     * @param data
     */
    public void insertHead(int data) {
        DoubleNode newDoubleNode = new DoubleNode(data);
        //链表为空的情况下
        if (head == null) {
            tail = newDoubleNode;
            head = newDoubleNode;
        } else {
            //链表原来的head的前驱指针指向newDoubleNode，newDoubleNode的后继指针指向head
            head.pre = newDoubleNode;
            newDoubleNode.next = head;
        }
        //最终把newDoubleNode作为head结点
        head = newDoubleNode;
    }

}

/**
 * @author LinKai
 * @time 2020/9/14-21:18
 */
class DoubleNode {
    int value;
    DoubleNode next;
    DoubleNode pre;

    /**
     * 构造方法
     *
     * @param value
     */
    DoubleNode(int value) {
        this.value = value;
        this.next = null;
        this.pre = null;
    }
}
