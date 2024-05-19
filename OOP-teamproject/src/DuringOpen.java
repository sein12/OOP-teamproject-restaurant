import java.util.Scanner;

public class DuringOpen {
    private Table table1 = new Table();
    private Server server = new Server();
    private Manager manager = new Manager();
    private Scanner scanner = new Scanner(System.in);

    public void openRestaurant() {
        printBanner("매장이 오픈했습니다. 영업을 시작합니다.");
        /*
        for (int hour = 12; hour <= 18; hour++) {
            printBanner("현재 시간: " + hour + ":00");
            handleCustomer(hour);
        }
        */
        printBanner("현재 시간: " + 12 + ":00");
        handleCustomer(12);
    }

    private void handleCustomer(int hour) {
        printBanner("손님 입장");
        server.welcome();
        server.reservationsEntry(hour);

        if (!table1.isAvailable()) {
            printBanner("테이블이 가득 찼습니다. 다음 손님을 기다립니다.");
            return;
        }

        printBanner("메뉴 안내");
        server.menuGuidance();
        
        printBanner("주문 받기");
        server.orderManager();
        
        printBanner("Server 대기 중");
        server.standby();
        

        double totalPrice = table1.getTotalPrice();
        server.FeedbackPayied(totalPrice);
        table1.reset(); // 결제 후 테이블 초기화

        printBanner("현재 시간 " + hour + ":00의 손님 처리가 완료되었습니다. 다음 손님을 맞이합니다.");
    }


    private void printBanner(String message) {
        System.out.println("===========================================");
        System.out.println(message);
        System.out.println("===========================================");
    }
}
