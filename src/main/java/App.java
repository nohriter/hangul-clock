import java.util.Scanner;

public class App {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printMenu();

        switch (selectMenu()) {
            case "1":
                printClock();
            case "2":
                printCalendar();
        }
    }

    private static void printCalendar() {

    }

    private static void printClock() {
        Clock clock = new Clock();
        clock.print();
    }

    private static String selectMenu() {
        InputConsoleView inputConsoleView = new InputConsoleView();
        return inputConsoleView.inputString();
    }

    private static void printMenu() {
        System.out.println("메뉴를 선택하세요.");
        System.out.println("1.시계");
        System.out.println("2.달력");
    }
}
