package leetcode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author: LinKai
 * @time: 2021/1/30-22:53
 */

public class Solution2 {
    /**
     * 思路：
     * 同时遍历两个链表
     * 只需要按照两数相加的思路，得出的结果放到新的链表
     * 有进位数放到下一个节点相加
     * 长度不同则默认短的链表后面的数为0
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 首先声明两个节点，头节点、尾节点
        ListNode head, tail;

        // 头节点、尾节点都是位置标记节点，一开始没有数据时，头节点和尾节点在一起，后面头节点->……->尾节点
        head = new ListNode(0);
        tail = head;

        // 声明当前l1、l2节点的值以及二者之和及进位数
        int var1,var2,sum,carry=0;

        // 当两个链表还没有完结或者进位数不为0时
        while (l1 != null || l2 != null || carry != 0) {
            // 取值计算
            var1 = l1 == null ? 0 : l1.val;
            var2 = l2 == null ? 0 : l2.val;
            sum = var1 + var2 + carry;
            // 获得进位制
            carry = sum / 10;
            // 当前新链表节点的值
            sum = sum % 10;

            // 初始化当前节点,注意是将当前的节点作为当前链表的尾节点的后继节点
            tail.next = new ListNode(sum);
            // 将当前的节点标记为尾节点
            tail = tail.next;

            // 两个链表继续遍历
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        // 最后返回该链表的第一个节点（head节点只是空的标记节点）
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}