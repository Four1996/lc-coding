package leetcode;

import java.util.HashMap;

/**
 * @author panhao
 * @date 2021年04月04日 10:08 上午
 */
public class NumRabbits_n781 {
    public static int numRabbits(int[] answers){
        int ans=0;
        int l=answers.length;
        if (l==0) return 0;
        HashMap<Integer,Integer> map=new HashMap();
        for (int i=0;i<l;i++){
            if (i==0&&answers[i]!=0){
                ans=answers[i]+1;
                map.put(answers[i],0);
            }else{
                if(answers[i]==0){
                    ans++;
                }else if (!map.containsKey(answers[i])){
                    map.put(answers[i],0);
                    ans+=answers[i]+1;
                }else{
                    int count=map.get(answers[i]);
                    if (answers[i]>count) {
                        count++;
                        map.put(answers[i],count);
                    }else{
                        map.put(answers[i],0);
                        ans+=answers[i]+1;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] answers={10,10,10};
        System.out.println(numRabbits(answers));
    }
}
