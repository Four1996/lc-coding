package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-10 22:30
 **/
public class CountTriple_5792 {
    public static int countTriples(int n) {
        int ans=0;
        if (n<5) return 0;
        for (int i=3;i<n;i++){
            for (int j=3;j<n;j++){
                int cc=i*i+j*j;
                float c= (float) Math.pow(cc,0.5);
                int ci=(int)c;
                if (c<=n&&ci==c) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countTriples(5));
    }
}
