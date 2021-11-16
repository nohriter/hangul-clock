import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock {
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
        for(int i=0; i < hangulClock[0].length; i++){
            for (int j=0; j < hangulClock[1].length; j++){
                System.out.print(hangulClock[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
