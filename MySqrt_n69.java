package leetcode;

/**
 * @author panhao
 * @date 2021年04月13日 9:56 下午
 */
public class MySqrt_n69 {
    public int mySqrt(int x){
        if (x==1) return 1;
        if (x==0) return 0;
        int left=1;
        int right=x/2;
        while(left<right){
            int mid=left+(right-left+1)/2;
            if (mid>x/mid) right=mid-1;
            else left=mid;
        }
        return left;
    }

    public static void main(String[] args) {
        MySqrt_n69 mySqrt_n69=new MySqrt_n69();
        System.out.println(mySqrt_n69.mySqrt(2147483647));
    }
}
