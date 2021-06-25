package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月19日 11:09 上午
 */
public class MergeTwoLists_n1928 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans=null;
        ListNode tail1=l1,tail2=l2;
        ListNode tail=null;
        while (tail1!=null&&tail2!=null){
            int minval;
            ListNode node;
            if (tail1.val<=tail2.val){
                minval=tail1.val;
                tail1=tail1.next;
            }else{
                minval=tail2.val;
                tail2=tail2.next;
            }
            node=new ListNode(minval);
            if (ans==null) ans=tail=node;
            else{
                tail.next=node;
                tail=node;
            }
        }
        if (tail1==null){
            while (tail2!=null){
                ListNode node=new ListNode(tail2.val);
                if (ans==null) ans=tail=node;
                else{
                    tail.next=node;
                    tail=node;
                }
                tail2=tail2.next;
            }
        }else{
            while (tail1!=null){
                ListNode node=new ListNode(tail1.val);
                if (ans==null) ans=tail=node;
                else{
                    tail.next=node;
                    tail=node;
                }
                tail1=tail1.next;
            }
        }
        return ans;
    }
}
