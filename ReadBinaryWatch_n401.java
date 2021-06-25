package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: first
 * @description: 二进制手表
 * @author: panhao
 * @date: 2021-06-21 08:30
 **/
public class ReadBinaryWatch_n401 {
    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count(i) + count(j) == turnedOn) {
                    ans.add(i + ":" + (j < 10 ? ("0" + j) : j));
                }
            }
        }
        return ans;
    }

    int count(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) res++;
            n = n >> 1;
        }
        return res;
    }
}
