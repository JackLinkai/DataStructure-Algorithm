package main.datastructure.list;

/**
 * 单向链表
 * @author LinKai
 * @time 2020/9/14-21:42
 */
public class MyLinkedList {

    /**
     *
     */
    private ListNode head;

    /**
     *
     */
    private int size = 0;

    /**
     * 插入链表的头部O(1)
     * @param data
     */
    public void insertHead(int data) {
        ListNode newNode = new ListNode(data);
        //将原来的头结点作为新插入的头结点的后继结点，如果原来为空，则指向的就是空，此时头结点也是尾结点，没毛病
        //.next是栈内存的引用，指向下一个地址
        newNode.next = head;
        //然后让新插入的结点作为头结点
        head = newNode;
    }

    /**
     * 中间插入数据，position是要插入的位置
     * @param data
     * @param position
     */
    public void insertNth(int data, int position) {
        if (position == 0) {
            //如果插入的是在头部
            insertHead(data);
        } else {
            //cur存储head，防止后续遍历操作丢失head
            ListNode cur = head;
            //用position=1测试，没毛病
            for (int i = 1; i < position; i++) {
                //往后遍历直到position位置所在的结点
                cur = cur.next;
            }
            ListNode newNode = new ListNode(data);
            //这一步是重点，应该把要插入的位置的后继结点先作为插入的结点的后继结点，然后再作为该位置的前驱节点的后继结点
            //不然后面的结点都会被丢失
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    /**
     * 删除头部O(1)
     */
    public void deleteHead() {
        //原来的head丢掉换成head的后继结点为head
        head = head.next;
    }

    /**
     * 删除中间，position是要删除的位置O(n)
     * @param position
     */
    public void deleteNth(int position) {
        //position为0时表示删除head
        if (position == 0) {
            //如果是删除head
            deleteHead();
        } else {
            ListNode cur = head;
            //同上
            for (int i = 1; i < position; i++) {
                //同上
                cur = cur.next;
            }
            //cur.next为要删除的结点，cur.next.next为要删除的结点的后继结点
            //将要删除的结点的后继结点作为它的前驱结点的后继结点，以此做到删除该节点
            cur.next = cur.next.next;
        }
    }

    /**
     * 查找O(n)
     * @param position
     */
    public void find(int position) {
        ListNode cur = head;
        //同上
        for (int i = 1; i < position; i++) {
            //同上
            cur = cur.next;
        }
        System.out.println(cur.value);
    }

    /**
     * 打印O(n)
     */
    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}

class ListNode {

    /**
     * 值
     */
    int value;

    /**
     * 后继指针
     */
    ListNode next;

    /**
     * 构造
     * @param value
     */
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }

}