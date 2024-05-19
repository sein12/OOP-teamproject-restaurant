import java.util.Scanner;

public class Server {
    private MenuCustomerPrice menuCustomerPrice = MenuCustomerPrice.getInstance();
    private StockAndCost stockAndCost = StockAndCost.getInstance();
    private ReservationSystem reservationSystem = ReservationSystem.getInstance(); // reservationsEntry 메서드에서 사용
    private CashPay cashPay = CashPay.getInstance(); // FeedbackPayied 메서드에서 사용
    private CardPay cardPay = CardPay.getInstance(); // FeedbackPayied 메서드에서 사용
    private Scanner scanner = new Scanner(System.in); // Scanner 객체를 클래스 레벨에서 한 번만 생성
    
    private int adults;
    private int children;

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    void welcome() { // 인사 메소드
        printBanner("안녕하세요. 식당에 오신 것을 환영합니다.", BLUE);
    }

    void reservationsEntry(int restaurantHours) { // 예약 입장 여부 메소드
        printBanner("이번 " + restaurantHours + "시 타임에 대해 예약 확인해 드리겠습니다.", PURPLE);
        if (reservationSystem.isReserved(restaurantHours - 12)) { // ReservationSystem 클래스의 메서드 사용
            printBanner("이번 타임에 대해 예약 확인 되었습니다. 바로 입장 도와드리겠습니다.", GREEN);
            countAdultsAndChildren();
        } else {
            printBanner("이번 타임에 대해 확인된 예약이 없습니다. 현장 입장 안내해드리겠습니다.", YELLOW);
            this.onTheSpotEntry(restaurantHours);
        }
    }

    void onTheSpotEntry(int restaurantHours) { // 현장 입장 확인 메소드; (세인)메인에서 시각 매개변수로 넣어서 쓰세요.
        printBanner("이번 " + restaurantHours + "시 타임에 대해 현장 입장 가능한지 확인해드리겠습니다.", PURPLE);
        if (Table.isOccupied) { // (세인) if문 돌아가기 전에 Table에서 isOccupied에 bool값 할당 위해 Table의 함수 호출 필요
            printBanner("죄송합니다. 남아있는 자리가 없으므로 현재 타임에는 식당 이용이 불가합니다. 다른 타임에 다시 방문하거나 다른 날짜에 대해 예약 후 방문해주세요.", RED);
        } else { // isOccupied == false면; 꽉 안참. 자리 안
            printBanner("현재 남아있는 좌석이 있습니다. 입장 도와드리겠습니다.", GREEN);
            countAdultsAndChildren();
        }
    }

    void countAdultsAndChildren() {
        System.out.println(CYAN + "성인과 청소년/어린이 수를 입력해주세요." + RESET);
        System.out.print("성인: ");
        adults = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        System.out.print("청소년/어린이: ");
        children = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        System.out.println(GREEN + "입력이 완료되었습니다." + RESET);
    }

    void menuGuidance() { // 모든 메뉴 안내 메소드; 가격도 포함
        System.out.println(YELLOW + "**********요리**********" + RESET);
        String[] courseMenu = menuCustomerPrice.getCourseMenuList();
        int[] coursePrice = menuCustomerPrice.getCoursePriceInt();
        for (int i = 0; i < courseMenu.length; i++) {
            System.out.println(courseMenu[i] + "    " + coursePrice[i] + "원");
        }

        System.out.println(YELLOW + "**********음료**********" + RESET);
        String[] drinkMenu = menuCustomerPrice.getDrinkMenuList();
        int[] drinkPrice = menuCustomerPrice.getDrinkPriceInt();
        for (int j = 0; j < drinkMenu.length; j++) {
            System.out.println(drinkMenu[j] + "    " + drinkPrice[j] + "원");
        }
    }

    void standby() { // 서버호출&대기 메소드
        while (true) {
            printBanner("필요한 것이 있으면 \"저기요\"라고 불러주세요.", CYAN);
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("저기요")) {
                printBanner("무엇을 도와드릴까요? (옵션: 주문하기 / 매니저 호출 / 주문 내역 / 결제)", CYAN);
                String answer2 = scanner.nextLine();

                switch (answer2) {
                    case "주문하기":
                        orderManager();
                        break;
                    case "매니저 호출":
                        callManager();
                        break;
                    case "결제":
                        double totalPrice = Main.table1.getTotalPrice();
                        FeedbackPayied(totalPrice);
                        return; // 결제가 완료되면 메서드 종료
                    case "주문 내역":
                        Main.table1.printOrder();
                        break;
                    default:
                        printBanner("올바른 옵션을 선택하지 않으셨습니다. 주문하기, 매니저 호출, 주문 내역 또는 결제 중에서 선택해주세요.", RED);
                        break;
                }
            } else {
                printBanner("올바른 호출이 아닙니다. 다시 시도해주세요.", RED);
            }
        }
    }
    
    void callManager() {
        printBanner("매니저를 호출합니다.", PURPLE);
        // 매니저 호출 로직을 추가할 수 있습니다.
    }

    void orderManager() {
        printBanner("주문을 도와드리겠습니다.", CYAN);
        System.out.println("아래의 메뉴 중 원하시는 메뉴의 수량을 입력해주세요.");

        String[] courseMenu = StockAndCost.DishMenu;
        String[] drinkMenu = StockAndCost.drinkMenu;

        for (int i = 0; i < courseMenu.length; i++) {
            System.out.println((i + 1) + ". " + courseMenu[i] + " - " + stockAndCost.getDishPriceInt(courseMenu[i]) + "원");
        }
        
        for (int i = 0; i < drinkMenu.length; i++) {
            System.out.println((courseMenu.length + i + 1) + ". " + drinkMenu[i] + " - " + stockAndCost.getDrinkPriceInt(drinkMenu[i]) + "원");
        }

        boolean ordering = true;

        while (ordering) {
            try {
                System.out.println("메뉴 번호를 입력해주세요 (종료는 0): ");
                int menuNumber = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리

                if (menuNumber == 0) {
                    ordering = false;
                } else {
                    String selectedMenu = "";
                    int stock = 0;
                    int price = 0;

                    if (menuNumber > 0 && menuNumber <= courseMenu.length) {
                        selectedMenu = courseMenu[menuNumber - 1];
                        stock = StockAndCost.getInstance().getDishStock(selectedMenu);
                        price = StockAndCost.getInstance().getDishPriceInt(selectedMenu);
                    } else if (menuNumber > courseMenu.length && menuNumber <= courseMenu.length + drinkMenu.length) {
                        selectedMenu = drinkMenu[menuNumber - 1 - courseMenu.length];
                        stock = StockAndCost.getInstance().getDrinkStock(selectedMenu);
                        price = StockAndCost.getInstance().getDrinkPriceInt(selectedMenu);
                    } else {
                        printBanner("잘못된 메뉴 번호입니다.", RED);
                        continue;
                    }

                    System.out.println(selectedMenu + "을/를 몇 개 주문하시겠습니까?");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 처리

                    if (quantity <= stock) {
                        // 주문이 가능하면 재고를 줄이고 주문을 처리
                        if (menuNumber > 0 && menuNumber <= courseMenu.length) {
                            StockAndCost.getInstance().subtractCourseStock(selectedMenu, quantity);
                        } else if (menuNumber > courseMenu.length && menuNumber <= courseMenu.length + drinkMenu.length) {
                            StockAndCost.getInstance().subtractDrinkStock(selectedMenu, quantity);
                        }

                        Main.table1.orderUpdated(selectedMenu, Main.table1.getOrderCount(selectedMenu) + quantity); // 기존 주문에 추가
                        Main.table1.updateTotalPrice();
                        RevenueAndCost.revenue += price * quantity;
                        printBanner(selectedMenu + "을/를 " + quantity + "개 주문했습니다.", GREEN);
                    } else {
                        // 재고가 부족할 경우
                        printBanner("최대 " + stock + "개만 주문 가능합니다.", RED);
                    }
                }
            } catch (Exception e) {
                printBanner("잘못된 입력입니다. 다시 시도해주세요.", RED);
                scanner.next(); // 잘못된 입력으로 인한 무한 루프 방지
            }
        }
    }

    void FeedbackPayied(double price) { // 결제 메소드 (세인) 여기 매개 변수 넣어주세요; 테이블마다의 가격
        printBanner("결제에 앞서 피드백을 받고 있습니다. 익명성이 보장되며 자유롭게 참여하실 수 있습니다.", CYAN);    // 결제메소드에서 피드백 받음
        Feedback feedback = Feedback.getInstance(); // Feedback 싱글톤
        feedback.getFeedback(); // 결제하기 전 피드백 받기
        System.out.println("결제를 원하시는 수단을 입력해주세요(카드 / 현금): ");
        String payMethod = scanner.nextLine();
        if (payMethod.equals("카드")) {        // 카드로 결제한다고 하면
            cardPay.pay(price);                // 위에서 넣은 변수가 여기서 매개변수로 쓰임. 위에서 CardPay 싱글톤 객체 선언함.
        }
        else if (payMethod.equals("현금")) {   // 현금으로 결제한다고 하면
            cashPay.pay(price);                // 위에서 넣은 변수가 여기서 매개변수로 쓰임. 위에서 CashPay 싱글톤 객체 선언함.
        }
    }

    private void printBanner(String message, String color) {
        System.out.println(color + "===========================================");
        System.out.println(message);
        System.out.println("===========================================" + RESET);
    }
}
