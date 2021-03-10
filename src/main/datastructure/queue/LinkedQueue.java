package main.datastructure.queue;

/**
 * @author: LinKai
 * @time: 2021/1/12-12:11
 */

public class LinkedQueue<Item> {
    // 头节点
    private Node head;
    // 尾节点
    private Node tail;
    // 当前已使用的空间
    private int size;

    /**
     * 构造方法
     */
    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 判空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队
     *
     * @param element
     */
    public void push(Item element) {
        Node node = new Node(element);
        if (isEmpty()) {
            head = node;
            tail = head.next;
        } else {
            tail = node;
            node.next = tail;
        }
        size++;
    }

    /**
     * 出队
     *
     * @return
     */
    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = (Item) head.value;
        head = head.next;
        size--;
        return item;
    }
}

class Node<Item> {
    // 当前节点
    public Item value;
    // 下个节点
    public Node next;

    /**
     * 构造方法
     *
     * @param value
     */
    public Node(Item value) {
        this.value = value;
        this.next = null;
    }

}
