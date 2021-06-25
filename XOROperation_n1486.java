package leetcode;

/**
 * @author panhao
 * @date 2021年05月07日 8:24 上午
 */
public class XOROperation_n1486 {
    public static int xorOperation(int n, int start) {
        int ans=start;
        for (int i=1;i<n;i++){
            ans^=(i*2+start);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5,0));
    }
}
