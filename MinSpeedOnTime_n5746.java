package leetcode;

/**
 * @author panhao
 * @date 2021年05月23日 10:41 上午
 */
public class MinSpeedOnTime_n5746 {
    public static int minSpeedOnTime(int[] dist, double hour) {
        if (hour<dist.length-1) return -1;
        int sum=0;
        for (int i:dist){
            sum+=i;
        }
        int left= (int) Math.ceil(sum/hour),right= (int) 1e7;
        while (left<right){
            int mid=left+(right-left)/2;
            if (check(dist,mid,hour)) right=mid;
            else left=mid+1;
        }
        return left;
    }
    static boolean check(int[] dist,int speed,double hour){
        double time =0;
        for (int i=0;i<dist.length-1;i++){
            time +=Math.ceil(dist[i]*1.0/speed);
        }
        time += (dist[dist.length-1]*1.0)/speed;
        return time <=hour;
    }

    public static void main(String[] args) {
        int[] nums={1,1,100000};
        int a=5,v=2;
        System.out.println(Math.ceil(a/v));
        System.out.println(Math.ceil(a*1.0/v));
        System.out.println(minSpeedOnTime(nums,2.01));
    }
}
