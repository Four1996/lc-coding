package leetcode.swordoffer;

import java.util.Stack;

/**
 * @author panhao
 * @date 2021年05月20日 4:26 下午
 */
public class VerifyPostorder_n1938 {
    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    static boolean recur(int[] postorder,int i,int j){
        if (i>=j) return true;
        int p=i;
        while (postorder[p]<postorder[i]) p++;
        int m=p;
        while (postorder[p]>postorder[j]) p++;
        return p==j&&recur(postorder,i,m-1)&&recur(postorder,m,j-1);
    }

    public static void main(String[] args) {
        int[] nums={1,6,3,2,5};
        System.out.println(verifyPostorder(nums));
    }
}
