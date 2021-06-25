package leetcode;

/**
 * @author panhao
 * @date 2021年05月27日 9:17 上午
 */
public class HammingDistance_n461_2 {
    public static int hammingDistance(int x, int y) {
        int ans=0;
        int s=x^y;
        while (s!=0){
            ans++;
            s&=s-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }
}
