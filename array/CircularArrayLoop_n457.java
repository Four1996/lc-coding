package leetcode.array;

import java.util.HashSet;

/**
 * @program: first
 * @description: 环形数组是否存在循环
 * @author: panhao
 * @date: 2021-08-07 09:44
 **/
public class CircularArrayLoop_n457 {
    static int[] nums;
    static int len;
    public static boolean circularArrayLoop(int[] _nums) {
        len = _nums.length;
        nums=_nums;
        for (int i = 0; i < nums.length; i++) {
            if (check(i)) return true;
        }
        return false;
    }

    private static boolean check(int s) {
        int cur=s;
        boolean postive=nums[cur]>0;
        int k=1;
        while (true){
            if (k>len) return false;
            // 巧妙啊，这样就不用根据正负分开计算下标了！！
            int next=((cur+nums[cur])%len+len)%len;
            if (postive&&nums[next]<0) return false;
            if (!postive&&nums[next]>0) return false;
            if (next==s) return k>1;
            cur=next;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums={-1,2};
        System.out.println(circularArrayLoop(nums));
    }
}
