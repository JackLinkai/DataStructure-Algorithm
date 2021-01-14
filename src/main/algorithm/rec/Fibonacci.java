package main.algorithm.rec;

/**
 * 1 1 2 3 5 8 13……
 *
 * @author: LinKai
 * @time: 2021/1/12-21:10
 */

public class Fibonacci {
    /**
     * 时间复杂度2^n，空间复杂度为2^n
     *
     * @param n
     * @return
     */
    public static int calculateFibonacci(int n) {
        // 递归的终止条件
        if (n <= 2) {
            return 1;
        }
        // 继续递归的过程
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    /**
     * 能用递归解决的问题也可以不使用递归解决，不用递归时间复杂度为O(n)
     *
     * @param n
     * @return
     */
    public static int noRecursion(int n) {
        if (n <= 2) {
            return 1;
        }
        int fibonacci2 = 1;
        int fibonacci1 = 1;
        int fibonacci = 0;
        for (int i = 3; i <= n; i++) {
            fibonacci = fibonacci1 + fibonacci2;
            fibonacci2 = fibonacci1;
            fibonacci1 = fibonacci;
        }
        return fibonacci;
    }

    /**
     * 存储斐波那契数列的数组
     */
    public static int[] data;

    /**
     * 我们发现有很多数值是被重复计算了
     * 解决：借助数组存储计算结果对递归进行优化
     * 时间复杂度O(n),空间复杂度T(n)
     *
     * @param n
     * @return
     */
    public static int optimizedRecursion(int n) {
        if (n <= 2) {
            return 1;
        }
        // 如果已经计算过了，直接返回该值
        if (data[n] > 0) {
            return data[n];
        }
        // 继续递归的过程
        // 把结果记录在data数组中
        data[n] = optimizedRecursion(n - 1) + optimizedRecursion(n - 2);
        return data[n];
    }

    /**
     * 我们发现，之所以会重复的进行计算是因为函数的末尾还有操作
     * 导致还要去创建新的栈而不能利用之前得出的结果
     * 我们先通过数的阶乘的计算尝试实现尾递归
     * 先用普通的递归实现：
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        // 出口
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * 尾递归实现数的阶乘
     * 其中，n为要计算的数
     * res为上一步的结果
     * 这样把上一步的结果传入下一步的计算
     * 便不用在函数末尾再次操作了
     *
     * @param n
     * @param res
     * @return
     */
    public static int tailRecursionFactorial(int n, int res) {
        System.out.println(n + ":" + res);
        // 出口
        if (n <= 1) {
            // 结果是从末尾向前继续传递的，所以到出口的时候就是输出结果了
            return res;
        }
        return tailRecursionFactorial(n - 1, n * res);
    }

    /**
     * 斐波那契的尾递归
     *
     * @param pre 上一次运算出来的结果
     * @param res 当前运算的结果
     * @param n   n是肯定要有的
     * @return
     */
    public static int tailRecursion(int pre, int res, int n) {
        // 递归的终止条件
        if (n <= 2) {
            // 结果是从末尾向前继续传递的，所以到出口的时候就是输出结果了
            return res;
        }
        // 继续递归的过程
        // 结果是从末尾向前继续传递的，
        // 所以前一次的上一个运算结果就是本次的当前结果，
        // 前一次的当前结果就应该是本次的下一个结果了，
        // 要理解是从末尾向前计算结果
        return tailRecursion(res, res + pre, n - 1);
    }

    public static void main(String[] args) {
        /*
        System.out.println("用递归所耗费的时间:");
        for (int i=30;i<=40;i++){
            long start =System.currentTimeMillis();
            System.out.print(i+":"+calculateFibonacci(i)+"("+(System.currentTimeMillis()-start)+"ms)"+"\t");
        }
        System.out.println();
        System.out.println("不用递归所耗费的时间:");
        for (int i=30;i<=40;i++){
            long start =System.currentTimeMillis();
            System.out.print(i+":"+NoRecursion(i)+"("+(System.currentTimeMillis()-start)+"ms)"+"\t");
        }
        System.out.println();
        System.out.println("加缓存优化的递归所耗费的时间:");
        data=new int[41];
        for (int i=30;i<=40;i++){
            long start =System.currentTimeMillis();
            System.out.print(i+":"+NoRecursion(i)+"("+(System.currentTimeMillis()-start)+"ms)"+"\t");
        }
         */

        /*
        阶乘的尾递归，结果是从末尾向前继续传递的，初始结果就为5^0=1
        4:5
        3:20
        2:60
        1:120
        120
        System.out.println(tailRecursionFactorial(5, 1));
         */

        // 斐波那契数列
        System.out.println("用尾递归所耗费的时间:");
        for (int i = 30; i <= 40; i++) {
            long start = System.currentTimeMillis();
            System.out.print(i + ":" + tailRecursion(1, 1, i) + "(" + (System.currentTimeMillis() - start) + "ms)" + "\t");
        }

        /**
         * 建议：
         * 如果发现题目可以使用递归实现的话，
         * 没有把握就用加缓存的递归或者是不用递归
         * 但是前往不要用递归
         */
    }
}
