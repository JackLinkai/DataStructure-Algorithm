package java.datastructure.array;

/**
 * 实现一个数组
 *
 * @author LinKai
 * @time 2020/9/14-20:45
 */
public class MyArray {
    /**
     * 数组长度
     */
    private int size;

    /**
     * 存储数组的空间
     */
    private int[] data;

    /**
     * 当前已经存的数据大小（小于size）
     */
    private int index;

    /**
     * 扩容因子0.75f
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 数组初始化
     * @param size
     */
    public MyArray(int size) {
        this.size = size;
        // 初始化数组
        data = new int[size];
        index = 0;
    }

    /**
     * 打印数组
     */
    public void print() {
        System.out.println("index:" + index);
        for (int i = 0; i < index; i++) {
            System.out.print(data[i] + "");
        }
        System.out.println();
    }

    /**
     * 插入
     * @param loc
     * @param n
     */
    public void insert(int loc, int n) {
        // 如果存的数据数目没有超过数组长度的0.75倍
        if (index++ < size * DEFAULT_LOAD_FACTOR) {
            // 将插入点后面的数据一个个往后移动
            for (int i = size - 1; i > loc; i--) {
                data[i] = data[i - 1];
            }
            // 然后将插入的数据存储到指定的位置
            data[loc] = n;
        } else {
            // 扩容因子0.75 扩容为size*2 也就是存储数据的数目已经超过数组长度的0.75，便将数组的长度设置为原来的2倍
            size = size << 1;
            // 然后初始化一个数组长度为原来两倍的新数组
            int[] temp = new int[size];
            // 将原来数组的数据复制到新的数组
            for (int i = 0; i < size >> 1; i++) {
                temp[i] = data[i];
            }
            // 完成扩容
            data = temp;
        }

    }

    /**
     * 删
     * @param loc
     */
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

    /**
     * 改
     * @param loc
     * @param n
     */
    public void update(int loc, int n) {
        data[loc] = n;
    }

    /**
     * 查
     * @param loc
     * @return
     */
    public int get(int loc) {
        return data[loc];
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(8);
        int n = 10;
        for (int i = 0; i < n; i++) {
            array.insert(i, i);
        }
        array.print();
    }
}