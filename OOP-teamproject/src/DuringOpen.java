import java.util.Scanner;

public class DuringOpen {
    private Table table1 = new Table();
    private Server server = new Server();
    private Manager manager = new Manager();
    private Scanner scanner = new Scanner(System.in);

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    public void openRestaurant() {
    	for (int hour = 12; hour <= 18; hour++) {
    		printBanner("현재 시간: " + hour + ":00", GREEN);
            handleCustomer(hour);
        }
    }

    private void handleCustomer(int hour) {
        printBanner("손님 입장", GREEN);
        server.welcome();
        server.reservationsEntry(hour);

        if (!table1.isAvailable()) {
            printBanner("테이블이 가득 찼습니다. 다음 손님을 기다립니다.", RED);
            return;
        }

        printBanner("메뉴 안내", CYAN);
        server.menuGuidance();
        
        printBanner("주문 받기", CYAN);
        server.orderManager();
        
        printBanner("Server 대기 중", CYAN);
        server.standby();

        double totalPrice = table1.getTotalPrice();
        server.FeedbackPayied(totalPrice);
        table1.reset(); // 결제 후 테이블 초기화

        printBanner("현재 시간 " + hour + ":00의 손님 처리가 완료되었습니다. 다음 손님을 맞이합니다.", GREEN);
    }

    private void printBanner(String message, String color) {
        System.out.println(color + BOLD + "===========================================");
        System.out.println(message);
        System.out.println("===========================================" + RESET);
    }
}
