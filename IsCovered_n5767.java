package leetcode;

/**
 * @author panhao
 * @date 2021年06月12日 10:31 下午
 */
public class IsCovered_n5767 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int len=ranges.length;
        boolean tag=false;
        for (int i=left;i<=right;i++){
            for (int j=0;j<len;j++){
                if (i>=ranges[j][0]&&i<=ranges[j][1]) {
                    tag=true;
                    break;
                }
            }
            if (tag==false) return false;
            tag=false;
        }
        return true;
    }
}
