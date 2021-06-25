package leetcode.swordoffer;

/**
 * @author panhao
 * @date 2021年05月18日 10:18 下午
 */
public class IsNumber_n1924 {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        //面向测试用例编程，末尾有空格算数字？不解
        s = s.trim();
        try{
            double a = Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }
        char c = s.charAt(s.length()-1);
        //特，末尾有f，d,D这些不算，但是3.算数字（面向测试用例编程）
        return (c >= '0' && c <= '9') || c == '.';
    }

    public static void main(String[] args) {
        System.out.println(new IsNumber_n1924().isNumber("12e+5.4"));
    }
}
