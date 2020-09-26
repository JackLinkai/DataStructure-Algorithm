package java.datastructure.stack;

import java.util.Objects;

/**
 * @author LinKai
 * @time 2020/9/14-21:49
 */
public class MyArrayStack<Item> implements MyStack<Item> {

    private Item[] a = (Item[]) new Object[1];

    /**
     * 大小
     */
    private int n = 0;


    @Override
    public MyStack push(Item item) {
        return null;
    }

    /**
     *
     */
    private void judgeSize() {
        if (a.length <= n) {
            resize(a.length << 1);
        }
    }

    /**
     * 扩容
     *
     * @param size
     */
    private void resize(int size) {
        Item[] temp = (Item[]) new Objects[size];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }

    }

    @Override
    public Item pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
