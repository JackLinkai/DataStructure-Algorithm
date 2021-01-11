package main.datastructure.stack;


import java.util.Objects;

/**
 * @author LinKai
 * @time 2020/9/14-21:49
 */
public class MyArrayStack<Item> implements MyStack<Item> {

    /**
     * 扩容缩容倍数
     */
    private static final int EXPANSION = 2;

    private Item[] a = (Item[]) new Object[1];

    /**
     * 初始的元素个数
     */
    private int n = 0;

    public MyArrayStack(int cup) {
        a = (Item[]) new Object[cup];
    }

    public MyArrayStack() {
    }

    /**
     * 入栈
     *
     * @param item
     * @return
     */
    @Override
    public MyStack push(Item item) {
        judgeSize();
        a[n++] = item;
        return null;
    }

    /**
     * 扩容规则
     */
    private void judgeSize() {
        if (n >= a.length) {
            resize(a.length * EXPANSION);
        } else if (n > 0 && n < a.length / EXPANSION) {
            resize(a.length / EXPANSION);
        }
    }

    /**
     * 扩容操作
     *
     * @param size
     */
    private void resize(int size) {
        Item[] temp = (Item[]) new Object[size];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        //n是个数，且前面是n++，所以应该先自减才可以定位到出栈的位置进行出栈，所以是--n
        Item item = a[--n];
        // 释放空间
        a[n] = null;
        return item;
    }

    /**
     * 大小
     *
     * @return
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return n == 0 ? true : false;
    }

}
