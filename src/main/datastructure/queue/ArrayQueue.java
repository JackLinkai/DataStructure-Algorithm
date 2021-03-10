package main.datastructure.queue;

/**
 * @author: LinKai
 * @time: 2021/1/10-22:26
 */

public class ArrayQueue {
    // 存储数据的数组
    private final int[] queue;
    // 头部指针
    private int head = 0;
    // 尾部指针
    private int tail = 0;
    // 总容量
    private final int n;
    // 已经使用的空间
    private int size = 0;

    public ArrayQueue(int cup) {
        queue = new int[cup];
        n = cup;
    }

    /**
     * 入队
     *
     * @param element
     */
    public void push(int element) {
        if (tail == n) {
            // 满了就不能入队列了
            if (size == n) {
                return;
            }
            // 没有满则将数据向前移动
            move();
        }
        // 数据先入队然后指针向后移动一位
        queue[tail++] = element;
        // 已使用的空间数加一
        size++;
    }

    /**
     * 将数据向前移动避免浪费数据
     */
    private void move() {
        for (int i = 0; i < size; i++) {
            queue[i] = queue[head + i];
        }
        head = 0;
        tail = size;
    }

    public int pop() {
        // 判空
        if (isEmpty()) {
            // 空则返回-1
            return -1;
        }
        // 获取队列头
        int element = queue[head];
        // 头部指针向后移动一位
        head++;
        // 已使用的空间减一
        size--;
        // 返回原来的队列头
        return element;
    }

    public boolean isEmpty() {
        // 如果头部指针移动到和尾部指针一个位置，说明队列为空
        return head == tail;
    }
}
