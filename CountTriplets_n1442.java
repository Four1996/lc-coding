package leetcode;

/**
 * @author panhao
 * @date 2021年05月18日 9:54 上午
 */
public class CountTriplets_n1442 {
    int sumXor[];
    int lowbit(int x){
        return x&(-x);
    }
    void add(int x,int value){
        while (x<sumXor.length){
            sumXor[x]^=value;
            x+=lowbit(x);
        }
    }
    int query(int x){
        int sum=0;
        while (x!=0){
            sum^=sumXor[x];
            x-=lowbit(x);
        }
        return sum;
    }
    public int countTriplets(int[] arr) {
        int ans=0;
        int i,j,k;
        sumXor=new int[arr.length+1];
        for (int u=1;u<sumXor.length;u++){
            add(u,arr[u-1]);
        }
        for (i=1;i< sumXor.length-1;i++){
            for (j=i+1;j<sumXor.length;j++){
                for (k=j;k<sumXor.length;k++){
                    if ((query(j-1)^query(i-1))==(query(k)^query(j-1))) ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,1,1};
        System.out.println(new CountTriplets_n1442().countTriplets(arr));
    }
}
