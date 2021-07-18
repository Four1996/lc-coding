package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-07-18 10:35
 **/
public class AddRungs_n5841 {
    public static int addRungs(int[] rungs, int dist) {

        int len=rungs.length;
        int ans=0;
        int step=0;
        for (int i=0;i<len;i++){
            if (step+dist>=rungs[i]){
                step=rungs[i];
            }else{
                while (step<rungs[i]){
                    ans++;
                    step+=dist;
                }
                ans--;
                step=rungs[i];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,10};
        System.out.println(addRungs(nums,2));
    }
}
