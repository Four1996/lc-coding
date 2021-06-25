package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author panhao
 * @date 2021年05月01日 11:31 下午
 */
public class ClosestRoom_n5733_2 {
    public static  int[] closestRoom(int[][] rooms, int[][] queries) {
        int[][] q=new int[queries.length][3];
        for(int i=0;i<q.length;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }
        Arrays.sort(q,(x,y)->y[1]-x[1]);
        Arrays.sort(rooms,(x,y)->y[1]-x[1]);
        TreeSet<Integer> set=new TreeSet<>();
        int idx=0;
        int[] ans=new int[q.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<q.length;i++){
            while(idx<rooms.length&&rooms[idx][1]>=q[i][1]){
                set.add(rooms[idx][0]);
                idx+=1;
            }
            Integer a=set.floor(q[i][0]);//返回小于等于当前期望房间id的最大值
            Integer b=set.ceiling(q[i][0]);//返回大于等于当前期望房间id的最最小值
            if(a==null&&b==null){
                ans[q[i][2]]=-1;
            }else if(b==null||a==null){
                ans[q[i][2]]=(a==null)?b:a;
            }else{
                ans[q[i][2]]=((q[i][0]-a)<=(b-q[i][0]))?a:b;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] rooms={{1,4},{2,3},{3,5},{4,1},{5,2}};
        int[][] q={{2,3},{2,4},{2,5}};
        for (int i:closestRoom(rooms,q)){
            System.out.println(i);
        }
//        TreeSet<Integer> treeSet=new TreeSet();
//        treeSet.add(5);
//        treeSet.add(10);
//        treeSet.add(2);
//        treeSet.add(11);
//        Integer ceiling = treeSet.ceiling(6);
//        System.out.println(ceiling);
//        System.out.println(treeSet);

    }
}
