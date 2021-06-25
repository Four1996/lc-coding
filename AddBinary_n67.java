package leetcode;

/**
 * @author panhao
 * @date 2021年04月19日 9:00 上午
 */
public class AddBinary_n67 {
    public String addBinary(String a,String b){
        String ans="";
        int carry=0;
        int l1=a.length(),l2=b.length();
        String add="";
        for (int i=0;i<Math.abs(l1-l2);i++){ add+="0";}
        if (l1>=l2) { add+=b;b=add; }
        else { add+=a;a=add; }
        for (int i=a.length()-1;i>=0;i--){
            if (carry==1){//进位为1
                int cur=Integer.valueOf((a.charAt(i)-'0')+(b.charAt(i)-'0'))+carry;
                if (cur/2>0){
                    ans+=String.valueOf(cur%2);
                    carry=1;
                }else{
                    ans+="1";
                    carry=0;
                }
            }else{//进位为0
                int cur=Integer.valueOf((a.charAt(i)-'0')+(b.charAt(i)-'0'));
                if (cur/2==1){
                    ans+="0";
                    carry=1;
                }else{
                    ans+=String.valueOf(cur%2);
                    carry=0;
                }
            }
        }
        if (carry==1) ans+="1";
        String str="";
        for (int i=ans.length()-1;i>=0;i--){
            str+=ans.charAt(i);
        }
        return str;
    }

    public static void main(String[] args) {
        String l1="1010",l2="1011";
        AddBinary_n67 addBinary_n67=new AddBinary_n67();
        System.out.println(addBinary_n67.addBinary(l1,l2));
    }
}
