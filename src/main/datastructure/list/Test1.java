package main.datastructure.list;

/**
 * 约瑟夫问题是个有名的问题：
 * N个人围成一圈，
 * 从第一个开始报数，
 * 第M个将被杀掉，
 * 最后剩下一个，
 * 其余人都将被杀掉。
 * 例如N=6，M=5，
 * 被杀掉的顺序是：5，4，6，2，3，1。
 * 现在问你最后留下的人是谁？
 * 比如N=6，M=5
 * 留下的就是1
 * 1 2 3 4 5 6 => 6 1 2 3 4 => 6 1 2 3 =>1 2 3 => 1 3 => 1
 * 思路：单循环链表
 *
 * @author: LinKai
 * @time: 2021/1/8-19:05
 */

public class Test1 {

    public static void main(String[] args) {
        CycleLinkedList c = new CycleLinkedList();
        for (int i = 7; i > 0; i--) {

            c.add(i);
        }
        int x = c.delect(6);
        System.out.println(x);
    }
}

class CycleLinkedList {
    // 头
    private CycleNode head;
    // 尾
    private CycleNode tail;

    public CycleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 从头部插入
     *
     * @param value
     */
    public void add(int value) {
        CycleNode cycleNode = new CycleNode(value);
        // 链表为空时
        if (head == null) {
            // 尾节点和头节点都指向新插入的节点
            head = cycleNode;
            tail = cycleNode;
        } else {
            // 新的节点的后继指针指向头节点所指向的节点
            cycleNode.next = head;
        }
        // 再把头节点指向新插入的节点
        head = cycleNode;
        // 尾节点指向头节点
        tail.next = head;
    }


    public int delect(int frequency) {
        // 先定义一个删除的指针
        CycleNode delect = new CycleNode();
        // 指针先指向头节点
        delect = head;
        // 从1到frequency开始报数,直到只剩最后一个
        for (int i = 1; i < frequency; i++) {
            // 当手绢丢下时
            if (i == frequency - 1) {
                // 将手绢丢到的人淘汰
                // 如果丢到的是尾部的
                if (delect.next == tail) {
                    //重新标记尾部
                    tail = tail.next;
                }
                delect.next = delect.next.next;
                // 重现标记头节点
                head = tail.next;
                // 重新开始报数
                i = 0;
            }
            // 一个一个地报数
            delect = delect.next;
            if (head.next == head) {
                break;
            }
        }
        // 返回最后胜利的人
        return delect.value;
    }
}

class CycleNode {
    // 值
    int value;
    // 后继节点
    CycleNode next;

    public CycleNode(int value) {
        this.value = value;
        this.next = null;
    }

    public CycleNode() {
    }
}