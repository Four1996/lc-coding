package leetcode;

public class KnightDialer_n935 {
    private  final int mod=1000000007;
    private  int [][] map={{4,6},{6,8},{7,9},{4,9},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
    public int knightDialer(int n){
        int[][] dp=new int[n][10];
        for (int i=0;i<10;i++){//先将第零次的迭代写完。
            dp[0][i]=1;//表示第0次调到各个号码的全部可能都为1。
        }
        for (int time=1;time<n;time++ ){
            
        }

        return n;
    }
}
