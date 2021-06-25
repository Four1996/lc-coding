package leetcode;

/**
 * @program: first
 * @description:
 * @author: panhao
 * @date: 2021-06-20 10:38
 **/
public class NumberOfRounds_n5789 {
    public static int numberOfRounds(String startTime, String finishTime) {
        String[] split1 = startTime.split(":");
        int startH = Integer.parseInt(split1[0]);
        int startM = Integer.parseInt(split1[1]);
        String[] split2 = finishTime.split(":");
        int endH = Integer.parseInt(split2[0]);
        int endM = Integer.parseInt(split2[1]);
        int hours = 0;
        if (startM > 45) {
            startH = (++startH) % 24;
            startM = 0;
        }
        if (endH < startH) {
            if (startM!=0){
                hours=24-(startH+1)+endH;
            }else{
                hours = 24 - startH + endH;
            }

        } else if (endH == startH && endM < startM) {
            hours = 23;
        } else {
            if (startM != 0) {
                hours = endH - (startH + 1);
            } else {
                hours = endH - startH;
            }
        }
        if (startM > 0 && startM < 15) startM = 15;
        else if (startM > 15 && startM < 30) startM = 30;
        else if (startM > 30 && startM < 45) startM = 45;
        else if (startM > 45 && startM != 0) startM = 0;

        if (endM > 0 && endM < 15) endM = 0;
        else if (endM > 15 && endM < 30) endM = 15;
        else if (endM > 30 && endM < 45) endM = 30;
        else if (endM > 45 && endM != 0) endM = 45;
        int ans = 0;
        if (hours == 0) {
            if (startH!=endH){
                ans= ((60 - startM) % 60) / 15 + endM / 15;
            }else{
                ans = (endM - startM) / 15;
            }
        } else {
            ans = hours * 4 + ((60 - startM) % 60) / 15 + endM / 15;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "14:41", f = "15:24";
        System.out.println(numberOfRounds(s, f));
    }
}
