package leetcode.binarySearch;

/**
 * @program: first
 * @description: H指数II
 * @author: panhao
 * @date: 2021-07-12 09:41
 **/
public class HIndexII_n275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len - 1;
        if (citations[len - 1] == 0) return 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (len - mid <= citations[mid]) right = mid;
            else left = mid + 1;
        }
        return len - left;
    }

}
