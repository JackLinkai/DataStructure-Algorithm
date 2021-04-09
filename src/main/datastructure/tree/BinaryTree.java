package main.datastructure.tree;

/**
 * @author: LinKai
 * @time: 2020/10/16-14:00
 */
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode D = new TreeNode('D', null, null);
        TreeNode H = new TreeNode('H', null, null);
        TreeNode K = new TreeNode('K', null, null);
        TreeNode C = new TreeNode('C', D, null);
        TreeNode G = new TreeNode('G', H, K);
        TreeNode B = new TreeNode('B', null, C);
        TreeNode F = new TreeNode('F', G, null);
        TreeNode E = new TreeNode('E', null, F);
        TreeNode A = new TreeNode('A', B, E);

        BinaryTree tree = new BinaryTree();
        System.out.println("前序遍历");
        tree.pre(A);
        System.out.println();
        System.out.println("中序遍历");
        tree.in(A);
        System.out.println();
        System.out.println("后序遍历");
        tree.lat(A);
    }

    public void print(TreeNode node) {
        System.out.print(node.getData());
    }

    /**
     * 前序遍历：根（输出）左右
     * 时间复杂度都是O(n)
     *
     * @param root
     */
    public void pre(TreeNode root) {
        print(root);
        if (root.getLeft() != null) {
            pre(root.getLeft());
        }
        if (root.getRight() != null) {
            pre(root.getRight());
        }
    }

    /**
     * 中序遍历：左根（输出）右
     *
     * @param root
     */
    public void in(TreeNode root) {
        if (root.getLeft() != null) {
            in(root.getLeft());
        }
        print(root);
        if (root.getRight() != null) {
            in(root.getRight());
        }
    }

    /**
     * 后序遍历：左右根（输出）
     *
     * @param root
     */
    public void lat(TreeNode root) {
        if (root.getLeft() != null) {
            lat(root.getLeft());
        }
        if (root.getRight() != null) {
            lat(root.getRight());
        }
        print(root);
    }

}

class TreeNode {

    private char data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(char data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
