package baekjoon.class1;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2884
// 알람 시계
public class AlarmClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fortyFive = 45;
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        sc.close();
        // 1. 원래 맞춰진 분에 45분을 뺐을 때, 0보다 작아진 수가 된다면 시간에 -1을 하고 60에 그 작아진 수를 더한다 (작아진 수가 마이너스이므로)
        int sub = minute - fortyFive;
        if(minute - fortyFive < 0) {
            // 2. 시간이 0보다 작아진다면 작아진 수에 24를 더한다.
            hour = hour-1;
            if(hour < 0) {
                hour = 24 + hour;
            }
            minute = 60 + sub;
        } else {
            minute = sub;
        }
        String newhour = String.valueOf(hour);
        String newMinute = String.valueOf(minute);
//        if(newhour.length() == 1 && newhour.charAt(0) != '0') { // 1시일때 01시로 변경
//            newhour = "0" + newhour.charAt(0);
//        }
//        if(newMinute.length() == 1) { // 1분일때 01분으로 변경
//            newMinute = "0" + newMinute.charAt(0);
//        }
        System.out.printf("%s %s",newhour, newMinute);
    }
}
