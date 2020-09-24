package java.datastructure.stack;

/**
 * @author LinKai
 * @time 2020/9/14-21:51
 */
public interface MyStack<Item> {

    /**
     * 入栈
     * @param item
     * @return
     */
    MyStack<Item> push(Item item);

    /**
     * 出栈
     * @return
     */
    Item pop();

    /**
     * 大小
     * @return
     */
    int size();

    /**
     * 判空
     * @return
     */
    boolean isEmpty();

}
