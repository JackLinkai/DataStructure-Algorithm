package main.datastructure.queue;

/**
 * @author: LinKai
 * @time: 2021/1/10-22:26
 */

public class CycleArrayQueue {
    // 存储数据的数组
    private int[] queue;
    // 头部指针
    private int head = 0;
    // 尾部指针
    private int tail = 0;
    // 总容量
    private int n;

    public CycleArrayQueue(int cup) {
        queue = new int[cup];
        n = cup;
    }

    /**
     * 入队
     *
     * @param element
     */
    public void push(int element) {
        // 满了就不能入队列了
        if ((tail + 1) % n == head) {
            return;
        }
        // 数据先入队然后指针向后移动一位
        queue[tail] = element;
        // 防止越界
        tail = (tail + 1) % n;
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
        head = (head + 1) % n;
        // 返回原来的队列头
        return element;
    }

    public boolean isEmpty() {
        // 如果头部指针移动到和尾部指针一个位置，说明队列为空
        if (head == tail) {
            return true;
        }
        return false;
    }
}
