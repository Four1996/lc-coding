package leetcode;

/**
 * @author panhao
 * @date 2021年06月12日 11:02 下午
 */
public class LargestMagicSquare_n5202 {
    public static int largestMagicSquare(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        if (row<2||col<2) return 1;
        int[][] preRowSum=new int[row][col+1];
        int[][] preColSum=new int[row+1][col];
        for (int i=0;i<row;i++){
            for (int j=1;j<=col;j++){
                preRowSum[i][j]=preRowSum[i][j-1]+grid[i][j-1];
            }
        }
        for (int j=0;j<col;j++){
            for (int i=1;i<=row;i++){
                preColSum[i][j]=preColSum[i-1][j]+grid[i-1][j];
            }
        }
        int ans=1;
        int k=2;
        while (k<=Math.min(row,col)){

            for (int i=0;i<=row-k;i++){
                for (int j=0;j<=col-k;j++){
                    int left=j,right=j+k;
                    int low=i,high=i+k;
                    int val=preRowSum[low][right]-preRowSum[low][left];
                    low++;
                    boolean tag=true;
                    while (low<=high){
                        if (val!=(preRowSum[low][right]-preRowSum[low][left])){
                            tag=false;
                            break;
                        }else{
                            low++;
                        }
                    }
                    if (tag){
                        low=i;
                        while (left<=right){
                            if (val!=(preColSum[high][left]-preRowSum[low][left])){
                                tag=false;
                                break;
                            }else{
                                left++;
                            }
                        }
                        if (tag){
                            int corner=0;
                            int sum=0;
                            while (corner<k){
                                sum+=grid[i+corner][j+corner];
                                corner++;
                            }
                            if (sum!=val) tag=false;
                            if (tag){
                                corner=0;
                               while (corner<k){
                                   sum-=grid[i+corner][j+k-corner];
                                   corner++;
                               }
                               if (sum!=0) tag=false;
                            }
                        }
                    }
                    if (tag){
                        ans=Math.max(ans,k);
                        break;
                    }
                }
            }
            k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arrays={{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(largestMagicSquare(arrays));
    }
}
