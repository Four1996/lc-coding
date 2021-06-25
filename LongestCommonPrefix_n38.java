package leetcode;

/**
 * @author panhao
 * @date 2021年04月12日 7:47 下午
 */
public class LongestCommonPrefix_n38 {
    public static String longestCommonPrefix(String[] strs){

        int len=strs.length;
        if (len==0) return "";
        if (len==1) return strs[0];
        String common=strs[0];
        for (int i=1;i<len;i++){
            if(common.length()>strs[i].length()) common=common.substring(0,strs[i].length());
            for (int j=0;j<Math.min(common.length(),strs[i].length());j++){
                if (common.charAt(j)!=strs[i].charAt(j)){
                    if (j==0) {
                        common="";
                        break;
                    }
                    common=common.substring(0,j);
                }
            }
        }
        return common;
    }

    public static void main(String[] args) {
        String[] strs={"dog","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
