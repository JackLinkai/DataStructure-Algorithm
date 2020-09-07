package java.DataStructure.array;

import java.lang.reflect.Array;

/**
 * 实现一个数组
 */
public class Solution2 {
    private int size;           //数组长度
    private int data[];         //存储数组的空间
    private int index;          //当前已经存的数据大小（小于size）

    //数组初始化
    public Solution2(int size) {
        this.size = size;
        data = new int[size];
        index = 0;
    }

    //打印数组
    public void print() {
        System.out.println("index:" + index);
        for (int i = 0; i < index; i++) {
            System.out.print(data[i] + "");
        }
        System.out.println();
    }

    //插入
    public void insert(int loc, int n) {
        if (index++ < size * 0.75) {
            for (int i = size - 1; i > loc; i--) {
                data[i] = data[i - 1];
            }
            data[loc] = n;
        } else {
            //扩容因子0.75 扩容为size*2
            size = size * 2;
            int temp[] = new int[size];
            for (int i = 0; i < size / 2; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

    }

    //删
    public void delete(int loc) {
        for (int i = loc; i < size; i++) {
            if (i != size - 1) {
                data[i] = data[i + 1];
            } else {
                //默认0就是没存数据
                data[i] = 0;
            }
        }
        index--;
    }

    //改
    public void update(int loc, int n) {
        data[loc] = n;
    }

    //查
    public int get(int loc) {
        return data[loc];
    }

    public static void main(String[] args) {
        //其实就是1个ArrayList

    }
}