package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-19 10:30
 **/
public class fFinalValueAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for (String operation : operations) {
            if (operation.equals("--X")){
                ans--;
            }else if (operation.equals("++X")){
                ans++;
            }else if (operation.equals("X++")){
                ans++;
            }else{
                ans--;
            }
        }
        return ans;
    }
}
