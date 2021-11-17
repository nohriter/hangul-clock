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


    public void print() {
        System.out.println("\n");

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

    public void getNowTime() {
        LocalTime localTime = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH mm");

        String formatTime = localTime.format(formatter);

        String[] hourAndMinute = formatTime.split(" ");

        this.hour = hourAndMinute[0];
        this.minute = hourAndMinute[1];
    }

    private void changeMinute() {
        String[] minutes = this.minute.split("");
        String firstMinute = minutes[0];
        String lastMinute = minutes[1];

        //기본값 십
        hangulClock[3][5] = ANSI_RED + hangulClock[3][5] + ANSI_RESET;

        switch (firstMinute) {
            case "0" :
                hangulClock[3][5] = "십";
                break;
            case "2" :
                hangulClock[3][1] = ANSI_RED + hangulClock[3][1] + ANSI_RESET;
                break;
            case "3" :
                hangulClock[3][2] = ANSI_RED + hangulClock[3][2] + ANSI_RESET;
                break;
            case "4" :
                hangulClock[3][3] = ANSI_RED + hangulClock[3][3] + ANSI_RESET;
                break;
            case "5" :
                hangulClock[3][4] = ANSI_RED + hangulClock[3][4] + ANSI_RESET;
                break;
        }

        //기본값 분
        hangulClock[5][5] = ANSI_RED + hangulClock[5][5] + ANSI_RESET;

        switch (lastMinute) {
            case "1" :
                hangulClock[4][1] = ANSI_RED + hangulClock[4][1] + ANSI_RESET;
                break;
            case "2" :
                hangulClock[4][2] = ANSI_RED + hangulClock[4][2] + ANSI_RESET;
                break;
            case "3" :
                hangulClock[4][3] = ANSI_RED + hangulClock[4][3] + ANSI_RESET;
                break;
            case "4" :
                hangulClock[4][4] = ANSI_RED + hangulClock[4][4] + ANSI_RESET;
                break;
            case "5" :
                hangulClock[5][1] = ANSI_RED + hangulClock[5][1] + ANSI_RESET;
                break;
            case "6" :
                hangulClock[4][5] = ANSI_RED + hangulClock[4][5] + ANSI_RESET;
                break;
            case "7" :
                hangulClock[5][2] = ANSI_RED + hangulClock[5][2] + ANSI_RESET;
                break;
            case "8" :
                hangulClock[5][3] = ANSI_RED + hangulClock[5][3] + ANSI_RESET;
                break;
            case "9" :
                hangulClock[5][4] = ANSI_RED + hangulClock[5][4] + ANSI_RESET;
                break;
        }

    }

    private void changeHour() {
        switch (this.hour) {
            case "01" :
            case "13" :
                hangulClock[0][0] = ANSI_RED + hangulClock[0][0] + ANSI_RESET;
                break;
            case "02" :
            case "14" :
                hangulClock[0][1] = ANSI_RED + hangulClock[0][1] + ANSI_RESET;
                break;
            case "03" :
            case "15" :
                hangulClock[0][2] = ANSI_RED + hangulClock[0][2] + ANSI_RESET;
                break;
            case "04" :
            case "16" :
                hangulClock[0][3] = ANSI_RED + hangulClock[0][3] + ANSI_RESET;
                break;
            case "05" :
            case "17" :
                hangulClock[0][4] = ANSI_RED + hangulClock[0][4] + ANSI_RESET;
                hangulClock[0][5] = ANSI_RED + hangulClock[0][5] + ANSI_RESET;
                break;
            case "06" :
            case "18" :
                hangulClock[1][0] = ANSI_RED + hangulClock[1][0] + ANSI_RESET;
                hangulClock[1][1] = ANSI_RED + hangulClock[1][1] + ANSI_RESET;
                break;
            case "07" :
            case "19" :
                hangulClock[1][2] = ANSI_RED + hangulClock[1][2] + ANSI_RESET;
                hangulClock[1][3] = ANSI_RED + hangulClock[1][3] + ANSI_RESET;
                break;
            case "08" :
            case "20" :
                hangulClock[1][4] = ANSI_RED + hangulClock[1][4] + ANSI_RESET;
                hangulClock[1][5] = ANSI_RED + hangulClock[1][5] + ANSI_RESET;
                break;
            case "09" :
            case "21" :
                hangulClock[2][0] = ANSI_RED + hangulClock[2][0] + ANSI_RESET;
                hangulClock[2][1] = ANSI_RED + hangulClock[2][1] + ANSI_RESET;
                break;
            case "10" :
            case "22" :
                hangulClock[2][2] = ANSI_RED + hangulClock[2][2] + ANSI_RESET;
                break;
            case "11" :
            case "23" :
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

}
