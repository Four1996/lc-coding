package leetcode;

/**
 * @author panhao
 * @date 2021年06月14日 9:04 上午
 */
public class GuessGame_n374 {
    public int guessNumber(int n) {
        int left=1,right=n,mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(guess(mid)>0) left=mid+1;
            else if(guess(mid)<0) right=mid-1;
            else break;
        }
        return mid;
    }

    private int guess(int mid) {
        return 1;
    }
}
