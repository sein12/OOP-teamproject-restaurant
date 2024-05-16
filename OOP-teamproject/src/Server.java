import java.util.Scanner;

public class Server {
    MenuCustomerPrice menu_and_price = MenuCustomerPrice.getInstance();
    StockAndCost stock_and_cost = StockAndCost.getInstance();
    Scanner scanner = new Scanner(System.in);
    private int adults;
    private int children;

    void welcome() { // 인사 메소드; 인삿말만 출력
        System.out.println("안녕하세요. 식당에 오신 것을 환영합니다.");
    }

    void reservationsEntry() { // 예약 입장/불가 메소드
        // DB에서 해당 타임 값 변수 만들면 가져오기
        System.out.println("이번 " + Table.currentTime + "시 타임에 대해 예약 확인해 드리겠습니다."); // 재윤이가 Table class에 static으로
                                                                                   // currentTime변수 만들어주기. Server에서는
                                                                                   // Table.currentTime으로 받아와서 쓸거임.

        if (Hall.reservationList[Table.currentTime - 12]) { // 재윤or정우가 Hall class에 reservationList[] static으로 만들어주기 boll
                                                            // type list입니다.
            System.out.println("이번 타임에 대해 예약 확인 되었습니다. 바로 입장 도와드리겠습니다.");
            countAdultsAndChildren();
        } else {
            System.out.println("이번 타임에 대해 확인된 예약이 없습니다. 현장 입장 안내해드리겠습니다.");
            this.onTheSpotEntry(); // else이면 현장 입장 메소드를 call함.
        }
    }

    void onTheSpotEntry() { // 현장 입장 확인 메소드
        System.out.println("이번 " + Table.currentTime + "시 타임에 대해 현장 입장 가능한지 확인해드리겠습니다.");
        if (Table.isOccupied) { // 현재 정우의 ReservationSystem.java에 있는 변수입니다. 재윤이의 Table class안에 static으로 옮겨주세요
            // isOccupied == true면; 자리 꽉 참. 이용 불가
            System.out.println("죄송합니다. 남아있는 자리가 없으므로 현재 타임에는 식당 이용이 불가합니다. 다른 타임에 다시 방문하거나 다른 날짜에 대해 예약 후 방문해주세요.");
        } else { // isOccupied == false면; 꽉 안참. 자리 안내
            System.out.println("현재 남아있는 좌석이 있습니다. 입장 도와드리겠습니다.");
            countAdultsAndChildren();
        }
    }

    void countAdultsAndChildren() {
        System.out.println("성인과 청소년/어린이 수를 입력해주세요.");
        System.out.println("성인: ");
        adults = scanner.nextInt();
        System.out.println("청소년/어린이: ");
        children = scanner.nextInt();
        System.out.println("입력이 완료되었습니다.");
    }

    void menuGuidance() { // 모든 메뉴 안내 메소드; 가격도 포함
        System.out.println("**********요리**********");
        for (int i = 0; i < menu_and_price.getCourseMenuList().length; i++) { // course_menu의 index값 개수만큼 메뉴와 가격을 나란히
                                                                              // 차례로 출력하기를 반복
            System.out.print(menu_and_price.getCourseMenuList()[i] + "    "); // 요리명과 가격을 나란히 출력할 수 있도록 print하고 enter안함.
            System.out.println(menu_and_price.getCoursePrice(menu_and_price.getCourseMenuList()[i])); // 다음 요리명과 가격을
                                                                                                      // 출력하기 위해 다음 줄로
                                                                                                      // 개행
        }
        System.out.println("**********음료**********");
        for (int j = 0; j < menu_and_price.getDrinkMenuList().length; j++) { // drink_menu의 index값 개수만큼 메뉴와 가격을 나란히 차례로
                                                                             // 출력하기를 반복
            System.out.print(menu_and_price.getDrinkMenuList()[j] + "    "); // 음료명과 가격을 나란히 출력할 수 있도록 print하고 enter안함.
            System.out.println(menu_and_price.getDrinkPrice(menu_and_price.getDrinkMenuList()[j])); // 다음 음료명과 가격을 출력하기
                                                                                                    // 위해 다음 줄로 개행
        }
    }

    void standby() { // 서버호출&대기 메소드
        System.out.println("필요한 것이 있으면 \"Server\"라고 불러주세요.");
        String answer = scanner.nextLine();

        if (answer.equals("Server")) {
            System.out.println("무엇을 도와드릴까요?(옵션: 주문하기 / 매니저 호출 / 주문 내역 / 결제)");
            String answer2 = scanner.nextLine();

            if (answer2.equals("주문하기")) {
                // 주문 메서드 넣기
            } else if (answer2.equals("매니저 호출")) {
                // 메니저 클래스 만들고 갖다 쓰던지 하기
            } else if (answer2.equals("결제")) {
                // 결제 메서드 넣기
            } else if (answer2.equals("주문 내역")) {
                // 주문 내역 메서드 넣기
            } else {
                System.out.println("올바른 옵션을 선택하지 않으셨습니다. 주문하기, 매니저 호출, 주문 내역 또는 결제 중에서 선택해주세요.");
                standby();// else일 때만 standby()를 재귀로 다시 호출
            }
        }
    }

    void orderManager() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("주문을 도와드리겠습니다.");
        System.out.println("아래의 메뉴 중 원하시는 메뉴의 수량을 입력해주세요.");

        String[] courseMenu = StockAndCost.DishMenu;
        String[] drinkMenu = StockAndCost.drinkMenu;

        for (int i = 0; i < courseMenu.length; i++) {
            System.out.println((i + 1) + ". " + courseMenu[i] + " - " + StockAndCost.DishPriceInt[i] + "원");
    
        }
        for (int i = 0; i < drinkMenu.length; i++) {
            System.out.println(
                    (courseMenu.length + i + 1) + ". " + drinkMenu[i] + " - " + StockAndCost.drinkPriceInt[i] + "원");
        }

        boolean ordering = true;

        while (ordering) {
            try {
                System.out.println("메뉴 번호를 입력해주세요 (종료는 0): ");
                int menuNumber = scanner.nextInt();

                if (menuNumber == 0) {
                    ordering = false;
                } else {
                    String selectedMenu = "";
                    int stock = 0;

                    if (menuNumber > 0 && menuNumber <= courseMenu.length) {
                        selectedMenu = courseMenu[menuNumber - 1];
                        stock = StockAndCost.getInstance().getDishStock(selectedMenu);
                    } else if (menuNumber > courseMenu.length && menuNumber <= courseMenu.length + drinkMenu.length) {
                        selectedMenu = drinkMenu[menuNumber - 1 - courseMenu.length];
                        stock = StockAndCost.getInstance().getDrinkStock(selectedMenu);
                    } else {
                        System.out.println("잘못된 메뉴 번호입니다.");
                        continue;
                    }

                    System.out.println(selectedMenu + "을/를 몇 개 주문하시겠습니까?");
                    int quantity = scanner.nextInt();

                    if (quantity <= stock) {
                        // 주문이 가능하면 재고를 줄이고 주문을 처리
                        if (menuNumber > 0 && menuNumber <= courseMenu.length) {
                            StockAndCost.getInstance().subtractCourseStock(selectedMenu, quantity);
                            Main.table1.orderUpdated(selectedMenu, quantity);
                            Main.table1.updateTotalPrice();
                        } else if (menuNumber > courseMenu.length
                                && menuNumber <= courseMenu.length + drinkMenu.length) {
                            StockAndCost.getInstance().subtractDrinkStock(selectedMenu, quantity);
                            Main.table1.orderUpdated(selectedMenu, quantity);
                            Main.table1.updateTotalPrice();

                        }
                        System.out.println(selectedMenu + "을/를 " + quantity + "개 주문했습니다.");
                    } else {
                        // 재고가 부족할 경우
                        System.out.println("최대 " + stock + "개만 주문 가능합니다.");
                        orderManager(); // 재귀 호출로 다시 주문 받기
                    }
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                scanner.next(); // 잘못된 입력으로 인한 무한 루프 방지
            }
        }

        scanner.close();
    }

    void FeedbackPayied(double price) { // 결제 메소드 (세인) 여기 매개 변수 넣어주세요; 테이블마다의 가격
        System.out.println("결제에 앞서 피드백을 받고 있습니다. 익명성이 보장되며 자유롭게 참여하실 수 있습니다.");    // 결제메소드에서 피드백 받음
        Feedback feedback = Feedback.getInstance(); // (정우) Feedback 싱글톤으로 만들기 전임. 
        feedback.getFeedback(); // 결제하기 전 피드백 받기
        System.out.println("결제를 원하시는 수단을 입력해주세요(card/cash): ");
        Scanner scannere = new Scanner(System.in)
        String payMethod = scanner.nextLine();
        if (payMethod.equals("card")) {        // 카드로 결제한다고 하면
            CardPay cardPay = CardPay.getInstance(); // (정우) CardPay 싱글톤으로 만들기 전임.
            cardPay.pay(price)                            // 위에서 넣은 변수가 여기서 매개변수로 쓰임.
        }
        else if (payMethod.equals("cash")) {   // 현금으로 결제한다고 하면
            CashPay cashPay = CashPay.getInstance();// (정우) CashPay 싱글톤으로 만들기 전임.
            cashPay.pay(price)
        }
                                                                                                 // 둘의 인스턴스 생성
        
    }
} // Server Class 닫힘
