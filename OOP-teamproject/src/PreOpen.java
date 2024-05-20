import java.util.Scanner;

public class PreOpen {
    private Chef chef = new Chef();
    private Manager manager = new Manager();
    private Server server = new Server();
    private ReservationSystem reservationSystem = ReservationSystem.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public boolean openStore = false; // 매장 오픈 여부를 나타내는 플래그

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    public void chooseJob() {
        while (true) {
            printBanner("당신의 직업은 무엇입니까? *영업 시작을 원하신다면 매니저를 선택해주세요.*", CYAN);
            System.out.println("셰프 | 매니저 | 손님");
            System.out.println(CYAN + "-------------------------------------------" + RESET);

            String choice = scanner.nextLine();

            switch (choice) {
                case "셰프":
                    printBanner("셰프로 선택하셨습니다. 주방으로 이동합니다.", GREEN);
                    chefJob();
                    break;
                case "매니저":
                    printBanner("매니저로 선택하셨습니다. 매장 관리 모드로 이동합니다.", GREEN);
                    managerJob();
                    if (openStore) {
                        return; // 매장 오픈 시 메서드를 종료하여 Main으로 돌아감
                    }
                    break;
                case "손님":
                    printBanner("손님으로 선택하셨습니다. 예약 시스템으로 이동합니다.", GREEN);
                    guestJob();
                    break;
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", RED);
                    break;
            }
        }
    }

    public void chefJob() {
        while (true) {
            printBanner("할 일 선택", CYAN);
            System.out.println("1. 재고 확인");
            System.out.println("2. 재고 수정");
            System.out.println("3. 직업 선택으로 돌아가기");
            System.out.println(CYAN + "-------------------------------------------" + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    chef.getDishStock();
                    chef.getDrinkStock();
                    break;
                case 2:
                    chef.modifyDishStock();
                    chef.modifyDrinkStock();
                    break;
                case 3:
                    return; // 메서드 종료 후 직업 선택으로 돌아감
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", RED);
                    break;
            }
        }
    }

    public void managerJob() {
        while (true) {
            printBanner("할 일 선택", CYAN);
            System.out.println("1. 재무 관리");
            System.out.println("2. 오늘의 예약");
            System.out.println("3. 직업 선택으로 돌아가기");
            System.out.println(RED + "9. 매장 오픈" + RESET);
            System.out.println(CYAN + "-------------------------------------------" + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    RevenueAndCost.printFinanceReport();
                    break;
                case 2:
                    reservationSystem.callReservation();
                    break;
                case 3:
                    return; // 메서드 종료 후 직업 선택으로 돌아감
                case 9:
                    openStore = true; // 매장 오픈 여부 플래그 설정
                    return; // 메서드 종료 후 Main으로 돌아감
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", RED);
                    break;
            }
        }
    }

    public void guestJob() {
        printBanner("예약 시스템으로 이동합니다.", CYAN);
        reservationSystem.selectReservationTime();
    }

    private void printBanner(String message, String color) {
        System.out.println(color + BOLD + "===========================================");
        System.out.println(message);
        System.out.println("===========================================" + RESET);
    }
}
