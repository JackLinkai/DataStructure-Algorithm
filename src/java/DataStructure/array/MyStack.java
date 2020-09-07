package java.DataStructure.array;

import java.util.concurrent.ThreadPoolExecutor;

public interface MyStack<Item> {
    //入栈
    MyStack<Item> push(Item item);

    //出栈
    Item pop();

    //大小
    int size();

    //判空
    boolean isEmpty();

}
