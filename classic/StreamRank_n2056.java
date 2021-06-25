package leetcode.classic;

import java.util.TreeSet;

/**
 * @author panhao
 * @date 2021年05月31日 10:41 上午
 */
public class StreamRank_n2056 {
    TreeSet<Integer> treeSet;
    int[] numsA;
    int[] numsB;
    int count0;
    int lowBit(int x){
        return x&(-x);
    }
    int query(int index){
        int sum=0;
        while (index >0){
            sum+= numsA[index];
            index -=lowBit(index);
        }
        return sum;
    }
    void add(int index, int val){
        while (index < numsA.length){
            numsA[index]+=val;
            index +=lowBit(index);
        }
    }
    public StreamRank_n2056() {
        treeSet=new TreeSet<>();
        numsA =new int[50001];
        count0=0;
    }

    public void track(int x) {
        treeSet.add(x);
        if (x==0) count0++;
        else add(x,1);
    }

    public int getRankOfNumber(int x) {
        Integer num = treeSet.floor(x);
        if (num==null) return 0;
        else if (num==0) return count0;
        return query(num)+count0;
    }

    public static void main(String[] args) {
        StreamRank_n2056 o = new StreamRank_n2056();
        o.getRankOfNumber(1);
        o.track(0);
        o.getRankOfNumber(0);
    }
}
