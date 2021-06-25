package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author panhao
 * @date 2021年05月01日 11:31 下午
 */
public class ClosestRoom_n5733 {
    public static  int[] closestRoom(int[][] rooms, int[][] queries) {
        int[] ans=new int[queries.length];
        Arrays.fill(ans,-1);
        Arrays.sort(rooms, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (int i=0;i<queries.length;i++){
            int id=queries[i][0];
            int size=queries[i][1];
            int left=0,right=rooms.length-1;
            while (left<right){
                int mid=(left+right)/2;
                if (rooms[mid][1]<size) left=mid+1;
                else{
                    right=mid;
                }
            }
            if (rooms[left][1]<size) left++;
            int[][] dump=Arrays.copyOfRange(rooms,left,rooms.length);
            Arrays.sort(dump, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            left=0;
            right=dump.length-1;
            if (dump.length !=0) {
                while (left<=right){
                    int mid=(left+right)/2;
                    if (dump[mid][0]==id){
                        ans[i]=dump[mid][0];
                        break;
                    } else if (dump[mid][0]>id) right=mid-1;
                    else left=mid+1;
                }
                if (ans[i]==-1){
                    if (left==dump.length) ans[i]=dump[dump.length-1][0];
                    else if (right==-1) ans[i]=dump[0][0];
                    else{
                        int u=Math.abs(dump[left][0]-id);
                        int k=Math.abs(dump[right][0]-id);
                        if (u<k) ans[i]=dump[left][0];
                        else ans[i]=dump[right][0];
                    }
                }
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
    }
}
