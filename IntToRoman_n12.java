package leetcode;

/**
 * @author panhao
 * @date 2021年05月14日 8:25 上午
 */
public class IntToRoman_n12 {
    public String intToRoman(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int len=chars.length;
        String ans="";
        for (int i=0,k=len;i<len&&k>=1;i++,k--){
            int u=chars[i]-48;
            switch (k){
                case 1:
                    if(u<5&&u>0){
                        if (u==4) ans+="IV";
                        else{
                            for (int j=1;j<=u;j++){
                                ans+="I";
                            }
                        }
                    }else if(u>=5&&u<=9){
                        if (u==9){
                            ans+="IX";
                        }else if (u==5){
                            ans+="V";
                        }else{
                            ans+="V";
                            u=u-5;
                            for (int j=1;j<=u;j++){
                                ans+="I";
                            }
                        }
                    }
                    break;
                case 2:
                    if(u<5&&u>0){
                        if (u==4) ans+="XL";
                        else{
                            for (int j=1;j<=u;j++){
                                ans+="X";
                            }
                        }
                    }else if(u>=5&&u<=9){
                        if (u==9){
                            ans+="XC";
                        }else if (u==5){
                            ans+="L";
                        }else{
                            ans+="L";
                            u=u-5;
                            for (int j=1;j<=u;j++){
                                ans+="X";
                            }
                        }
                    }
                    break;
                case 3:
                   if(u<5&&u>0){
                        if (u==4) ans+="CD";
                        else{
                            for (int j=1;j<=u;j++){
                                ans+="C";
                            }
                        }
                    }else if(u>=5&&u<=9){
                       if (u==9){
                           ans+="CM";
                       }else if (u==5){
                           ans+="D";
                       }else{
                           ans+="D";
                           u=u-5;
                           for (int j=1;j<=u;j++){
                               ans+="C";
                           }
                       }
                    }
                    break;
                case 4:
                    for (int j=1;j<=u;j++){
                        ans+="M";
                    }
                    break;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new IntToRoman_n12().intToRoman(3));
    }
}
