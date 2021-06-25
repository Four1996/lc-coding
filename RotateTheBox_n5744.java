package leetcode;

import java.util.*;

/**
 * @author panhao
 * @date 2021年05月15日 10:54 下午
 */
public class RotateTheBox_n5744 {
    public static char[][] rotateTheBox(char[][] box) {
        int row=box.length,col=box[0].length;
        char[][] ans=new char[col][row];
        for (int i=0;i<col;i++){
            for (int j=0;j<row;j++){
                ans[i][j]='.';
            }
        }
        for (int i=0;i<row;i++){
            int stone=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            int j=0;
            for (;j<col;j++){
                if (box[i][j]=='#') stone++;
                if (box[i][j]=='*') {
                    map.put(j,stone);
                    stone=0;
                }
            }
            int u=row-i-1;
            if (map.size()==0){
                int num=0;
                for (int cur=col-1;cur>=0;cur--){
                    if (num<stone){
                        ans[cur][u]='#';
                        num++;
                    }
                    else break;
                }
            }else{
                for (Map.Entry<Integer, Integer> entry:map.entrySet()){
                    int cur=entry.getKey();
                    int stones=entry.getValue();
                    int num=0;
                    ans[cur][u]='*';
                    for (int k=cur-1;k>=0;k--){
                        if (num<stones){
                                ans[k][u]='#';
                                num++;
                        }
                        else break;

                    }
                }
                if (stone!=0){
                    int num=0;
                    for (int cur=col-1;cur>=0;cur--){
                        if (num<stone){
                            ans[cur][u]='#';
                            num++;
                        }else break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] box={
                {'.','*','#','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','*','.','#','.'}
        };
        System.out.println(rotateTheBox(box));
    }
}
