package leetcode.math;

/**
 * @program: first
 * @description: 一周中的第几天
 * @author: panhao
 * @date: 2022-01-03 14:47
 **/
public class dayOfTheWeek_n1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] weekday = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthday = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++) {
            days += monthday[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        days += day;
        return weekday[(days + 3) % 7];
    }
}
