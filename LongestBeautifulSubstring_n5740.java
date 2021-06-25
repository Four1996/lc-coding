package leetcode;

/**
 * @author panhao
 * @date 2021年04月25日 10:48 上午
 */
public class LongestBeautifulSubstring_n5740 {
    int[] dp;
    public int longestBeautifulSubstring(String word) {
        int len=word.length();
        if (len<5) return 0;
        dp=new int[len];
        int i=finda(0,word);
        if (i==len) return 0;
        dp[i]=1;
        int maxlen=0;
        for (int j=i+1;j<len;j++){
            if (dp[j-1]==0&&word.charAt(j-1)!='a'){
                int cur=finda(j,word);
                if (cur==len) break;
                dp[cur]=1;
            }else{
                if (word.charAt(j)>word.charAt(j-1)){
                    switch (word.charAt(j)){
                        case 'e':
                            if (word.charAt(j-1)=='a') dp[j]=dp[j-1]+1;
                            else dp[j]=0;
                            break;
                        case 'i':
                            if (word.charAt(j-1)=='e') dp[j]=dp[j-1]+1;
                            else dp[j]=0;
                            break;
                        case 'o':
                            if (word.charAt(j-1)=='i') dp[j]=dp[j-1]+1;
                            else dp[j]=0;
                            break;
                        case 'u':
                            if (word.charAt(j-1)=='o') {
                                dp[j]=dp[j-1]+1;
                                maxlen=maxlen>=dp[j]?maxlen:dp[j];
                            } else dp[j]=0;
                            break;
                        default:
                            break;
                    }
                }else if (word.charAt(j)==word.charAt(j-1)) {
                    dp[j]=dp[j-1]+1;
                    if (word.charAt(j)=='u'){
                        maxlen=maxlen>=dp[j]?maxlen:dp[j];
                    }
                }else{
                    if (word.charAt(j)=='a') dp[j]=1;
                    else dp[j]=0;
                }

            }
        }
        return maxlen;
    }
    int finda(int cur,String word){
        int i=cur;
        for (;i<word.length();i++){
            if (word.charAt(i)=='a'){
                break;
            }
            dp[i]=0;
        }
        return i;
    }

    public static void main(String[] args) {
        String word="eauoiouieaaoueiuaieoeauoiaueoiaeoiuieuaoiaeouiaueo";
        LongestBeautifulSubstring_n5740 l=new LongestBeautifulSubstring_n5740();
        System.out.println(l.longestBeautifulSubstring(word));
    }
}
