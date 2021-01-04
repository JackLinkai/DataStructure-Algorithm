package leetcode;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * 提示：
 * 0 <= n <= 5 * 10^6
 *
 * @author: LinKai
 * @time: 2020/12/3-12:56
 */

public class Solution204 {

    /**
     * 思路1：埃氏筛
     * 1. 自然数中，第一个质数为2，那么2的倍数则不是质数，排除；
     * 2. 以此类推，直到x，判断x是不是之前排除的数，不是看看是不是质数，是质数则排除x*x后面的数
     * 3. 创建一个长度为n+1的数组，下标为0~n，值为1则代表不是质数。
     *
     * @param n
     * @return
     */
    public int countPrimes1(int n) {
        // 计数器
        int nas = 0;
        // 初始化数组，数组下标为0~n
        int[] num = new int[n + 1];
        // 从第一个质数开始
        for (int i = 2; i < n; ++i) {
            // 如果是质数
            if (num[i] == 0) {
                // 计数器先加一
                nas++;
                // 先判断 i * i是否在0~n范围内，long防止int越界
                if ((long) i * i <= n) {
                    // 从 i * i开始，逐个将i的倍数标记为非质数
                    for (int j = i * i; j <= n; j += i) {
                        num[j] = 1;
                    }
                }
            }
        }
        return nas;
    }

    /**
     * 思路2：（优化）线性筛
     * 1. 由思路1我们可以发现，在标记非质数时可能重复标记，如12，既被2标记又被3标记
     * 2. 因此我们可以多维护一个数据存储当前得到的质数。我们从小到大遍历，如果当前是质数，加入该数组中
     * 3.
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        // 计数器
        int nas = 0;
        // 初始化数组，数组下标为0~n
        int[] num = new int[n + 1];
        // 从第一个质数开始
        for (int i = 2; i < n; ++i) {
            // 如果是质数
            if (num[i] == 0) {
                // 计数器先加一
                nas++;
                // 先判断 i * i是否在0~n范围内，long防止int越界
                if ((long) i * i <= n) {
                    // 从 i * i开始，逐个将i的倍数标记为非质数
                    for (int j = i * i; j <= n; j += i) {
                        num[j] = 1;
                    }
                }
            }
        }
        return nas;
    }







    static boolean[] primes;
    static int[] primesInt;
    static int pos;
    static int end;
    static {
        int n = 5 * 1000000;
        primes = new boolean[n >> 1];
        primes[0] = true;
        end = 1;
        // 5000000以内的质数 不会超过 50000个
        primesInt = new int[500000];
        pos = 0;
    }
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        // 用例有更多的数，计算剩下的数
        if (n - 1 > end) {
            int limit = (int) Math.sqrt(n);
            // 计算end之内的素数对多加的数的处理
            for (int j = 0; j < pos; j++) {
                int i = primesInt[j];
                if (i <= limit) {
                    int next = i * i;
                    if (next < end) {
                        int divide = end / i;
                        divide += (divide & 0x1) == 1 ? 2 : 1;
                        next = i * divide;
                    }
                    for (int k = next; k < n; k += (i << 1)) {
                        primes[k >> 1] = true;
                    }
                } else {
                    break;
                }
            }
            // 计算end之外的素数对多加的数的处理
            for (int i = end + 2; i <= limit; i += 2) {
                if (!primes[i >> 1]) {
                    primesInt[pos++] = i;
                    int divide = end / i;
                    divide += (divide & 0x1) == 1 ? 2 : 1;

                    for (int k = i * divide; k < n; k += (i << 1)) {
                        primes[k >> 1] = true;
                    }
                }
            }
            int nextCheck = (limit & 0x1) == 1 ? limit + 2 : limit + 1;
            nextCheck = Math.max(nextCheck, end + 2);
            // 把计算出的新范围的数放入素数数组
            for (int i = nextCheck ; i < n; i += 2) {
                if (!primes[i >> 1]) {
                    primesInt[pos++] = i;
                }
            }
            // 更新新的已计算过的数
            end = (n & 0x1) == 1 ? n - 2 : n - 1;
        }

        if (pos == 0 || n > primesInt[pos - 1]) {
            return pos + 1;
        } else {
            // 二分求范围n以内的素数个数，由于素数数组中不包括素数2，所以结果数量要加1
            int l = 0;
            int r = pos - 1;
            while (l < r) {
                int mid = l + (r - l >> 1);
                if (primesInt[mid] < n) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l + 1;
        }
    }

    public static void main(String[] args) {
        Solution204 solution204 = new Solution204();
        System.out.println(solution204.countPrimes1(499979));
    }
}
