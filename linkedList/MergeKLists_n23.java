package leetcode.linkedList;

/**
 * @program: first
 * @description: 合并K个升序链表
 * @author: panhao
 * @date: 2021-08-27 09:46
 **/
public class MergeKLists_n23 {
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length;
        if (len<1){
            return new ListNode();
        }
        if (len==1){
            return lists[0];
        }
        ListNode ans=null;
        for (int i=1;i<len;i++){
            if (ans==null){
                ans=mergeSort(lists[i-1],lists[i]);
            }else{
                ans=mergeSort(ans,lists[i]);
            }
        }
        return ans;
    }
    public ListNode mergeSort(ListNode list1,ListNode list2){
        ListNode tail1=list1,tail2=list2;
        ListNode res=null;
        ListNode tail=res;
        while (tail1!=null&&tail2!=null){
            ListNode node;
            if (tail1.val<=tail2.val){
                node=new ListNode(tail1.val);
                tail1=tail1.next;
            }else{
                node=new ListNode(tail2.val);
                tail2=tail2.next;
            }
            if (res==null){
                res=tail=node;
            }else{
                tail.next=node;
                tail=tail.next;
            }
        }
        if (tail1!=null){
            if (tail==null){
                res=tail1;
            }else{
                tail.next=tail1;
            }
        }
        if (tail2!=null){
            if (tail==null){
                res=tail2;
            }else{
                tail.next=tail2;
            }
        }
        return res;
    }
}
