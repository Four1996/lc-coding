package leetcode.binarySearch;

import java.util.Arrays;

/**
 * @program: first
 * @description: H指数
 * @author: panhao
 * @date: 2021-07-11 20:20
 **/
public class HIndex_n274 {
    public static int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        if (citations[len - 1] == 0) return 0;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= len - mid) right = mid;
            else left = mid + 1;
        }
        return len - left;
    }

    public static void main(String[] args) {
        int[] c={4,4,0,0};
        System.out.println(hIndex(c));
    }
}
