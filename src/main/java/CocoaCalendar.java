import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CocoaCalendar {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[1;91m";
    private static final InputConsoleView inputConsoleView = new InputConsoleView();

    private String year;
    private String month;
    private String day;
    private LocalDate nowDate;


    // 현재 달력
    public void printNowDate() {
        getNowDate();
        List<String> days = createCalendar(nowDate);
        printCalendar(days);
    }

    private void printCalendar(List<String> days) {
        int count = 0;

        for (String day : days) {
            if (day.equals(this.day + "\t")) {
                System.out.print(ANSI_RED + day + ANSI_RESET);
                count++;
                continue;
            }

            System.out.print(day);
            count++;

            if (count % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    private List<String> createCalendar(LocalDate date) {
        int lastDay = date.lengthOfMonth();                // 현재 날짜의 마지막 일수 ex) 28, 30, 31
        LocalDate localDate = date.withDayOfMonth(1);     // 현재 달의 1일을 localDate로 반환
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();     // 현재 달의 1일을 요일로 반환한다.
        int nowMonthFirstDay = dayOfWeek.getValue();       // 시작 요일을 숫자값으로 변환.
        List<String> days = new ArrayList<>();

        days.add("일\t");
        days.add("월\t");
        days.add("화\t");
        days.add("수\t");
        days.add("목\t");
        days.add("금\t");
        days.add("토\t");

        for (int i = 0; i < nowMonthFirstDay; i++) {
            days.add("\t");
        }

        for (int i = 1; i <= lastDay; i++) {
            days.add(i + "\t");
        }
        return days;
    }

    public void getNowDate() {
        nowDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YY MM dd");
        String formatTime = nowDate.format(formatter);
        String[] date = formatTime.split(" ");
        this.year = date[0];
        this.month = date[1];
        this.day = date[2];
    }

    //원하는 년도의 월 달력
    public void printAMonthOfYearDate() {
        printAMonthMessage();
        LocalDate AMonthOfYearDate = parseAMonthOfYearDate();
        printCalendar(createCalendar(AMonthOfYearDate));
    }

    private LocalDate parseAMonthOfYearDate() {
        int year = Integer.parseInt(this.year);
        int month = Integer.parseInt(this.month);
        return LocalDate.of(year, month, 1); //년,월,일
    }

    private void printAMonthMessage() {
        System.out.println("원하는 년도를 입력해 주세요 ex) 2021");
        this.year = inputConsoleView.inputYearDate();
        System.out.println("원하는 월을 입력해 주세요 ex) 12");
        this.month = inputConsoleView.inputMonthDate();
    }

    //원하는 년도의 모든 달력
    public void printAllMonthOfYearDate() {
        printAllMonthMessage();
        for(int i = 1; i <= 12; i++) {
            LocalDate AllMonthOfYearDate = parseAllMonthDate(i);
            printCalendar(createCalendar(AllMonthOfYearDate));
        }
    }

    private LocalDate parseAllMonthDate(int month) {
        int year = Integer.parseInt(this.year);
        return LocalDate.of(year, month, 1); //년,월,일
    }

    private void printAllMonthMessage() {
        System.out.println("원하는 년도를 입력해 주세요 ex) 2021");
        this.year = inputConsoleView.inputYearDate();

    }
}
