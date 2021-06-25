package leetcode.classic;

/**
 * @program: first
 * @description: 回文链表
 * @author: panhao
 * @date: 2021-06-23 09:47
 **/
public class IsPalindrome_n2037 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        int len=0;
        ListNode tail=head;
        while (tail!=null){
            len++;
            tail=tail.next;
        }
        int[] nums=new int[len];
        int idx=0;
        tail=head;
        while (tail!=null){
            nums[idx++]=tail.val;
            tail=tail.next;
        }
        int left=0,right=len-1;
        if (len%2==0){
            while (left<right){
                if (nums[left]!=nums[right]) return false;
                left++;
                right--;
            }
        }else{
            while (left<=right){
                if (nums[left]!=nums[right]) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
