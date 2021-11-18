import java.util.Scanner;

public class App {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printMainMenu();

        switch (selectMainMenu()) {
            case "1":
                runClock();
                break;
            case "2":
                runCalendar();
                break;
        }
    }

    private static void runCalendar() {
        CocoaCalendar calendar = new CocoaCalendar();
        printCalendarMenu();
        switch (selectCalendarMenu()) {
            case "1":
                calendar.printNowDate();
                break;
            case "2":
                calendar.printAMonthOfYearDate();
                break;
            case "3":
                calendar.printAllMonthOfYearDate();
                break;
        }
    }

    private static String selectCalendarMenu() {
        InputConsoleView inputConsoleView = new InputConsoleView();
        return inputConsoleView.inputCalendarMenu();
    }

    private static void printCalendarMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("1.현재 달력");
        System.out.println("2.원하는 날짜의 달력");
        System.out.println("3.원하는 년도의 모든 달력");
    }

    private static void runClock() {
        Clock clock = new Clock();
        clock.print();
    }

    private static String selectMainMenu() {
        InputConsoleView inputConsoleView = new InputConsoleView();
        return inputConsoleView.inputMainMenu();
    }

    private static void printMainMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("1.시계");
        System.out.println("2.달력");
    }
}
