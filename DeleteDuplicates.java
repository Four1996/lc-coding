package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class DeleteDuplicates {
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

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode findlen = new ListNode();
            int length = 0;
            for (findlen = head; findlen != null; findlen = findlen.next) {
                length++;
            }
            if (length == 1) {
                return head;
            } else if (length == 2) {
                if (head.val != head.next.val) {
                    return head;
                } else {
                    return null;
                }
            } else {
                HashMap<Integer, Integer> hm = new HashMap<>();
                for (int i = 0; head != null; head = head.next) {
                    if (hm.containsValue(head.val)) {
                        int t = head.val;
                        while (head != null && head.val == t) {
                            if (head.val == t) {
                                head = head.next;
                            }
                        }
                        hm.remove(--i, t);
                    }
                    if (head != null) {
                        hm.put(i, head.val);
                        i++;
                    } else {
                        break;
                    }
                }
                if (hm.size() != 0) {
                    ListNode dup = null;
                    ListNode dup_l = null;
                    for (int j = 0; !hm.isEmpty(); j++) {
                        ListNode newnode = new ListNode(hm.get(j));
                        if (dup == null) {
                            dup_l = dup = newnode;
                        } else {
                            dup_l.next = newnode;
                            dup_l = newnode;
                        }
                        hm.remove(j);
                    }
                    return dup;
                } else {
                    return null;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ListNode head = null;
        ListNode newhead = null;
        int m = input.nextInt();
        while (m != 0) {
            ListNode p = new ListNode(m);
            if (head == null) {
                newhead = head = p;
            } else {
                newhead.next = p;
                newhead = p;
            }
            m = input.nextInt();
        }
        deleteDuplicates(head);
    }
}
