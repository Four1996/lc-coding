package leetcode;

/**
 * @author panhao
 * @date 2021年06月13日 5:08 下午
 */
public class FirstBadVersion_n278 {
    public int firstBadVersion(int n) {
        int left=1,right=n;
        while (left<right){
            int mid=left+(right-left)/2;
            if (isBadVersion(mid)) right=mid;
            else left=mid+1;
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(0+(2147483647-0)/2);
    }
}
