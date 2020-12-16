//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
// 说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
// Related Topics 链表
// 👍 602 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    * 翻转链表的三代目题，第一代是翻转整个链表、第二代是翻转头部链表
    * 第三代取中间翻转，其实最简单的方法就是将链表切分开来，然后再翻转，
    * 然后再用一代目的做法，eazy。
    * 但是leetcode 上的看到这个用递归的方法真的太nb了
    * 具体的方法可以查看leetcode
    *https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
    * 我自机容易错的地方就是认清遍历到链表的位置，什么时候要用head，什么时候要用head.next
    * 需要分清之间的关系。希望过段时间再遇到这道题目的时候依然能够AC
    * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1){
            return reverse(head,n);
        }
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;

    }
    ListNode succeed = null;
    private ListNode reverse(ListNode head,int n){
        if(n == 1){
            succeed = head.next;
            return head;
        }
        ListNode last = reverse(head.next,n-1);
        head.next.next = head;
        head.next = succeed;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
