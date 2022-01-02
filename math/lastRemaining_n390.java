package leetcode.math;

/**
 * @program: first
 * @description: 消除游戏
 * @author: panhao
 * @date: 2022-01-02 15:25
 **/
public class lastRemaining_n390 {
    public int lastRemaining(int n) {
        int remain = n;
        int start = 1, step = 1;
        //true : 从左到右
        boolean flag = true;
        while (remain > 1) {
            //从左到右，或者从右到左同时剩余的数字个数为奇数时，首尾两个元素都会被清除掉
            //start表示剩余数字中的第一个（最后只会剩下start一个，就是我们要的结果）
            if (flag || remain % 2 != 0) {
                start += step;
            }
            remain /= 2;
            step *= 2;
            flag = !flag;
        }
        return start;
    }
}
