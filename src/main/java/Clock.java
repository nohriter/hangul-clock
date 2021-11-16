import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Clock {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[1;91m";

    private String hour;
    private String minute;
    private String[][] hangulClock = {
            {"한", "두", "세", "네", "다", "섯"},
            {"여", "섯", "일", "곱", "여", "덟"},
            {"아", "홉", "열", "한", "두", "시"},
            {"자", "이", "삼", "사", "오", "십"},
            {"정", "일", "이", "삼", "사", "육"},
            {"오", "오", "칠", "팔", "구", "분"}
    };


    public void getNowTime() {
        LocalTime localTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH mm");

        String formatTime = localTime.format(formatter);

        String[] hourAndMinute = formatTime.split(" ");

        this.hour = hourAndMinute[0];
        this.minute = hourAndMinute[1];
    }

    public void print() {
        getNowTime();
        changeHour();
        changeMinute();

        for (int i = 0; i < hangulClock[0].length; i++) {
            for (int j = 0; j < hangulClock[1].length; j++) {
                System.out.print(hangulClock[i][j] + "\t");
            }
            System.out.println();
        }

    }

    private void changeMinute() {

    }

    private void changeHour() {
//        Scanner sc = new Scanner(System.in);
//        hour = sc.next();
        System.out.println(this.hour);
        switch (this.hour) {
            case "01" :
                hangulClock[0][0] = ANSI_RED + hangulClock[0][0] + ANSI_RESET;
                break;
            case "02" :
                hangulClock[0][1] = ANSI_RED + hangulClock[0][1] + ANSI_RESET;
                break;
            case "03" :
                hangulClock[0][2] = ANSI_RED + hangulClock[0][2] + ANSI_RESET;
                break;
            case "04" :
                hangulClock[0][3] = ANSI_RED + hangulClock[0][3] + ANSI_RESET;
                break;
            case "05" :
                hangulClock[0][4] = ANSI_RED + hangulClock[0][4] + ANSI_RESET;
                hangulClock[0][5] = ANSI_RED + hangulClock[0][5] + ANSI_RESET;
                break;
            case "06" :
                hangulClock[1][0] = ANSI_RED + hangulClock[1][0] + ANSI_RESET;
                hangulClock[1][1] = ANSI_RED + hangulClock[1][1] + ANSI_RESET;
                break;
            case "07" :
                hangulClock[1][2] = ANSI_RED + hangulClock[1][2] + ANSI_RESET;
                hangulClock[1][3] = ANSI_RED + hangulClock[1][3] + ANSI_RESET;
                break;
            case "08" :
                hangulClock[1][4] = ANSI_RED + hangulClock[1][4] + ANSI_RESET;
                hangulClock[1][5] = ANSI_RED + hangulClock[1][5] + ANSI_RESET;
                break;
            case "09" :
                hangulClock[2][0] = ANSI_RED + hangulClock[2][0] + ANSI_RESET;
                hangulClock[2][1] = ANSI_RED + hangulClock[2][1] + ANSI_RESET;
                break;
            case "10" :
                hangulClock[2][2] = ANSI_RED + hangulClock[2][2] + ANSI_RESET;
                break;
            case "11" :
                hangulClock[2][2] = ANSI_RED + hangulClock[2][2] + ANSI_RESET;
                hangulClock[2][3] = ANSI_RED + hangulClock[2][3] + ANSI_RESET;
                break;
            case "12" :
                hangulClock[2][2] = ANSI_RED + hangulClock[2][2] + ANSI_RESET;
                hangulClock[2][4] = ANSI_RED + hangulClock[2][4] + ANSI_RESET;
                hangulClock[3][0] = ANSI_RED + hangulClock[3][0] + ANSI_RESET;
                hangulClock[4][0] = ANSI_RED + hangulClock[4][0] + ANSI_RESET;
                break;
            case "24" :
                hangulClock[2][2] = ANSI_RED + hangulClock[2][2] + ANSI_RESET;
                hangulClock[2][4] = ANSI_RED + hangulClock[2][4] + ANSI_RESET;
                hangulClock[4][0] = ANSI_RED + hangulClock[4][0] + ANSI_RESET;
                hangulClock[5][0] = ANSI_RED + hangulClock[5][0] + ANSI_RESET;
                break;
        }

        hangulClock[2][5] = ANSI_RED + hangulClock[2][5] + ANSI_RESET;
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.print();
    }
}
