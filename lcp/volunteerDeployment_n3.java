package leetcode.lcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-09-25 15:08
 **/
public class volunteerDeployment_n3 {
    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int n=finalCnt.length+1;
        int planLen=plans.length;
        // 邻接表
        List<List<Integer>> rec=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rec.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x=edge[0];
            int y=edge[1];
            rec.get(x).add(y);
            rec.get(y).add(x);
        }
        List<List<String>> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        List<HashMap<String,Integer>> list=new ArrayList<>();
        String temp="a";
        for (int i = n-1; i >=1 ; i--) {
            list.add(new HashMap<>());
            res.get(i).add(finalCnt[i-1]+"");
        }
        res.get(0).add(temp);
        for (int i = planLen-1; i >=0; i--) {
            int plan=plans[i][0];
            int target=plans[i][1];
            List<Integer> targetList = rec.get(target);
            if (plan==1){
                res.get(target).add("+"+res.get(target));
            }else if (plan==2){
                for (int t : targetList) {
                    res.get(t).add(String.valueOf(res.get(target)));
                    // res.get(t).add()
                    // res[t]-=res[target];
                }
            }else{
                for (int t : targetList) {
                    // res[t]+=res[target];
                }
            }
        }
        return null;

    }
}
