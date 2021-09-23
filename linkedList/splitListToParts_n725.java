package leetcode.linkedList;

/**
 * @program: first
 * @description: 分割链表
 * @author: panhao
 * @date: 2021-09-22 21:40
 **/
public class splitListToParts_n725 {
    public static class ListNode {
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

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int part = 0, all = 0, rest = 0;
        ListNode tail = head;
        while (tail != null) {
            all++;
            tail = tail.next;
        }
        rest = all % k;
        part = all / k;
        ListNode[] ans = new ListNode[k];
        tail = head;
        ListNode pre = tail;
        for (int i = 0; i < k; i++) {
            int count = 0;
            ans[i] = tail;
            ListNode temp=tail;
            if (tail == null) {
                continue;
            }
            while (count<part){

            }
            while (count < part && tail != null) {
                if (count == 0) {
                    tail = tail.next;
                } else {
                    pre = tail;
                    tail = tail.next;
                }
                count++;
            }
            if (rest > 0 && tail != null) {
                tail = tail.next;
                pre = tail;
                rest--;
            }
            if (pre!=null){
                pre.next = null;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        System.out.println(splitListToParts(n1,5));
    }
}
