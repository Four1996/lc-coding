package leetcode;

public class ReverseBetween {
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        ListNode search = head;
        ListNode res_r = res;
        int count = 0;
        if (head != null) {
            if (left == right) {
                return head;
            }
            while (search != null) {
                count++;
                search = search.next;
            }
            int orign[] = new int[count];
            int resor[] = new int[count];
            for (int i = 0; i < count; i++) {
                orign[i] = head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            int leftl = left, rightr = right;
            for (int i = 0; i < orign.length; i++) {
                if (i >= left - 1 && i <= right - 1) {
                    if (leftl == rightr) {
                        resor[i] = orign[i];
                    } else {
                        resor[leftl - 1] = orign[rightr - 1];
                    }
                    leftl++;
                    rightr--;
                } else {
                    resor[i] = orign[i];
                }
            }
            for (int i = 0; i < count; i++) {
                res.val = resor[i];
                if (res != null && i != count - 1) {
                    ListNode newNode = new ListNode(-1);
                    res.next = newNode;
                    res = res.next;
                }
            }
            return res_r;
        } else {
            return null;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        for (int i = 1; i < 6; i++) {
            if (head != null) {
                ListNode newNode = new ListNode(-1);
                head.val = i;
                if (i != 5) {
                    head.next = newNode;
                    head = head.next;
                }
            }
        }
        reverseBetween(res, 2, 4);
    }
}