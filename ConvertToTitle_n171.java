package leetcode;

/**
 * @author panhao
 * @date 2021年05月05日 8:12 下午
 */
public class ConvertToTitle_n171 {
    public static int convertToNumber(String columnTitle) {
        int ans=0;
        char[] chars = columnTitle.toCharArray();
        for (int i=0;i<chars.length;i++){
            int u=chars[i]+1-'A';
            ans=ans*26+u;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="XYZ";
        System.out.println(convertToNumber(s));

    }
}
