package leetcode;

/**
 * @author panhao
 * @date 2021年05月01日 10:46 下午
 */
public class SeatManager_n5731 {
    boolean[] seat;
    int cur=1;
    public SeatManager_n5731(int n) {
        seat=new boolean[n+1];
        for (int i=1;i<=n;i++){
            seat[i]=true;
        }
    }

    public int reserve() {
        if (seat[cur]==true){
            seat[cur]=false;
            cur++;
            return cur-1;
        }
        for (int i=cur;i<seat.length;i++){
                if (seat[i]==true){
                    seat[i]=false;
                    cur=i+1;
                    break;
                }
        }
        return cur-1;
    }

    public void unreserve(int seatNumber) {
        seat[seatNumber]=true;
        cur=seatNumber>cur?cur:seatNumber;
    }
}
