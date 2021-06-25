package leetcode;

/**
 * @author panhao
 * @date 2021年05月12日 8:09 上午
 */
public class XorQueries_n1310_2 {
    int[] preXOR;
    int lowbit(int x){
        return x&(-x);
    }
    int query(int x){
        int xorsum=0;
        while (x!=0){
            xorsum^= preXOR[x];
            x-=lowbit(x);
        }
        return xorsum;
    }
    void add(int x,int val){
        while (x< preXOR.length){
            preXOR[x]^=val;
            x+=lowbit(x);
        }
    }
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len= queries.length;
        preXOR =new int[arr.length+1];
        int[] ans=new int[len];
        for (int i=1;i<=arr.length;i++){
            add(i,arr[i-1]);
        }
        for (int i=0;i<len;++i){
            int left=queries[i][0];
            int right=queries[i][1];
            int leftxor=query(left);
            int rightxor=query(right+1);
            ans[i]=leftxor^rightxor;
        }
        return ans;
    }

    public static void main(String[] args) {
        XorQueries_n1310_2 x=new XorQueries_n1310_2();
        int[] nums={16};
        int[][] queries={{0,0},{0,0},{0,0}};
        for (int i:x.xorQueries(nums,queries)){
            System.out.println(i);
        }
    }
}
