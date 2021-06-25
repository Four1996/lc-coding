package leetcode;

/**
 * @author panhao
 * @date 2021年04月06日 8:39 上午
 */
public class RemoveDuplicates_n80 {
    public static int removeDuplicates(int [] nums){
//        int r=1;
//        int len=preXOR.length;
//        if (len<3) return len;
//        int count=1;
//        for (int i=0;i<preXOR.length&&preXOR[i]!=Integer.parseInt(null);){
//            if (preXOR[i]==preXOR[r]){
//                count++;
//                r++;
//                if(r== preXOR.length)break;
//                if(r==preXOR.length-1&&preXOR[i]==preXOR[r]){
//                    count++;
//                    for (int j=i+2;j<preXOR.length;j++){
//                        preXOR[j]= Integer.parseInt(null);
//                    }
//                    len=len-count+2;
//                    break;
//
//                }
//            }else if (count>2){
//                len=len-count+2;
//                int l=i+2,t=r;
//                for (int j=l;j<preXOR.length&&t< preXOR.length;j++,t++){
//                    preXOR[j]=preXOR[t];
//                    preXOR[t]=Integer.parseInt(null);
//                }
//                i=i+2;
//                r=i+1;
//                count=1;
//            }else{
//                count=1;
//                i++;
//                r=i+1;
//                if (r== preXOR.length)break;
//            }
//        }
//
//        return len;
        return process(nums,2);
    }
    static int process(int[] nums,int k){
        int u=0;
        for (int x:nums){
            if (u<k||nums[u-k]!=x) nums[u++]=x;
        }
        return u;
    }
    public static void main(String[] args) {
        int[] nums={-1,0,0,0,0,3,3};
        System.out.println(removeDuplicates(nums));
    }
}
