package main.datastructure.tree;

/**
 * 用数组实现二叉树
 * 下标1为根节点
 * 对于下标x的节点，左节点为2x，右节点为2x+1
 *
 * @author LinKai
 * @time 2021/04/09-23:08:00
 */
public class ArrayTree {

    private final char[] tree;

    public ArrayTree(char[] tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {
        char[] tree = {' ',
                            'A',
                        'B', 'E',
                    ' ', 'C', ' ', 'F',
                ' ', ' ', 'D', ' ', ' ', ' ', 'G', 'H'
        };

        ArrayTree arrayTree = new ArrayTree(tree);
        System.out.println("pre");
        arrayTree.pre(1);
        System.out.println();
        System.out.println("in");
        arrayTree.in(1);
        System.out.println();
        System.out.println("lat");
        arrayTree.lat(1);
        System.out.println();
        System.out.println("level");
        arrayTree.level();
    }

    /**
     * 前序遍历：根左右
     *
     * @param i
     */
    public void pre(int i) {
        System.out.print(tree[i]);
        int left = i * 2;
        int right = i * 2 + 1;
        if (left < tree.length && tree[left] != ' ') {
            pre(left);
        }
        if (right < tree.length && tree[right] != ' ') {
            pre(right);
        }
    }

    public void in(int i) {
        int left = i * 2;
        int right = i * 2 + 1;
        if (left < tree.length && tree[left] != ' ') {
            in(left);
        }
        System.out.print(tree[i]);
        if (right < tree.length && tree[right] != ' ') {
            in(right);
        }
    }

    public void lat(int i) {
        int left = i * 2;
        int right = i * 2 + 1;
        if (left < tree.length && tree[left] != ' ') {
            lat(left);
        }
        if (right < tree.length && tree[right] != ' ') {
            lat(right);
        }
        System.out.print(tree[i]);
    }

    public void level() {
        for (int i = 1; i < tree.length; i++) {
            if (tree[i] != ' ') {
                System.out.print(tree[i]);
            }
        }
    }
}
