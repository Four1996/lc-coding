package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author panhao
 * @date 2021年05月16日 9:33 下午
 */
public class FindMaximumXOR_421_2 {
    static final int High_BIT=31;
    class Node{
        Node[] ns=new Node[2];
    }
    Node root;
    public FindMaximumXOR_421_2() {
        root=new Node();
    }
    public void add(int x){
        Node p=root;
        for (int i=High_BIT;i>=0;i--){
            int u=(x>>i)&1;
            if (p.ns[u]==null) p.ns[u]=new Node();
            p=p.ns[u];
        }
    }
    public int getVal(int x){
        int ans=0;
        Node p=root;
        for (int i=High_BIT;i>=0;i--){
            int a=(x>>i)&1,b=1-a;
            if (p.ns[b]!=null){
                ans|=(b<<i);
                p=p.ns[b];
            }else{
                ans|=(a<<i);
                p=p.ns[a];
            }
        }
        return ans;
    }
    public  int findMaximumXOR(int[] nums) {
        int x=0;
        for (int i:nums){
            add(i);
            int j=getVal(i);
            x=Math.max(x,i^j);
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums={3,10,5,25,2,8};
        System.out.println(new FindMaximumXOR_421_2().findMaximumXOR(nums));
    }
}
