package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: first
 * @description: 二叉树寻路
 * @author: panhao
 * @date: 2021-07-29 09:20
 **/
public class PathInZigZagTree_n1104 {
    public static List<Integer> pathInZigZagTree(int label) {
        //当前节点所在的层数,从开始
        int level = (int) (Math.log(label) / Math.log(2)) + 1;//14 --> 4
        List<Integer> res = new ArrayList<>();
        //从最底层计算
        res.add(label);
        level--;//3
        int pre = label;
        while (level > 0) {
            if ((level + 1) % 2 == 0) {
                //之前层为偶数行,从右往左,找到pre的位置
                int left = (int) Math.pow(2, level + 1) - 1;//最左边的元素
                //cnt表示属于当前层的第几个节点
                int cnt = (left - pre) / 2;
                //计算当前层的节点,因为之前层为偶数层,那么当前层为奇数层
                int cur = (int) Math.pow(2, level - 1) + cnt;
                res.add(cur);
                pre = cur;
            } else {
                //level = 2
                //之前层为奇数行,从左往右,找到pre的位置
                int left = (int) Math.pow(2, level);//最左边的元素
                //cnt表示属于当前层的第几个节点
                int cnt = (pre - left) / 2;
                //计算当前层的节点,因为之前层为奇数层,那么当前层为偶数层
                int cur = (int) Math.pow(2, level) - cnt - 1;
                res.add(cur);
                pre = cur;
            }
            level--;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(14));
    }
}
