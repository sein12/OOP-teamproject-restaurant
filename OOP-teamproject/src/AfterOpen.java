import java.util.Scanner;

public class AfterOpen {
    private Chef chef = new Chef();
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

    public void closeOperations() {
        printBanner("매장이 영업을 종료했습니다. 이제 마감 작업을 시작합니다.", PURPLE);

        while (true) {
            printBanner("당신의 직업을 선택해주세요: 셰프 | 매니저", CYAN);
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "셰프":
                    chefOperations();
                    break;
                case "매니저":
                    managerOperations();
                    break;
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", RED);
                    break;
            }
        }
    }

    private void chefOperations() {
        while (true) {
            printBanner("셰프로 선택하셨습니다. 할 일을 선택해주세요:", CYAN);
            System.out.println("1. 재고 확인" + RESET);
            System.out.println("2. 직업 선택으로 돌아가기" + RESET);
            System.out.println(CYAN + "========================================================================================" + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    chef.getDishStock();
                    chef.getDrinkStock();
                    break;
                case 2:
                    return; // 메서드 종료 후 직업 선택으로 돌아감
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", RED);
                    break;
            }
        }
    }

    private void managerOperations() {
        while (true) {
            printBanner("매니저로 선택하셨습니다. 할 일을 선택해주세요:", CYAN);
            System.out.println("1. 피드백 검토" + RESET);
            System.out.println("2. 재무 관리" + RESET);
            System.out.println("3. 직업 선택으로 돌아가기" + RESET);
            System.out.println(RED + "9. 프로그램 종료" + RESET);
            System.out.println(CYAN + "========================================================================================" + RESET);

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    reviewFeedback();
                    manager.manageFeedback();
                    break;
                case 2:
                    RevenueAndCost.printFinanceReport();
                    break;
                case 3:
                    return; // 메서드 종료 후 직업 선택으로 돌아감
                case 9:
                    printBanner("프로그램을 종료합니다. 수고하셨습니다!", GREEN);
                    System.exit(0); // 프로그램 종료
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", RED);
                    break;
            }
        }
    }

    private void reviewFeedback() {
        Feedback feedback = Feedback.getInstance();
        feedback.setFeedback(); // 피드백 평균값 계산
        printBanner("피드백 검토:", CYAN);
        System.out.println("음식 평점: " + Feedback.foodRateMean + RESET);
        System.out.println("서비스 평점: " + Feedback.serviceRateMean + RESET);
        System.out.println("시설 평점: " + Feedback.facilityRateMean + RESET);
        System.out.println("========================================================================================" + RESET);
    }

    private void printBanner(String message, String color) {
        System.out.println(color + BOLD + "========================================================================================");
        System.out.println(message);
        System.out.println("========================================================================================" + RESET);
    }
}
