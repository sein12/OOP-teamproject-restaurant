import java.util.Scanner;

public class AfterOpen {
    private Chef chef = new Chef();
    private Manager manager = new Manager();
    private Scanner scanner = new Scanner(System.in);

    public void closeOperations() {
        printBanner("매장이 영업을 종료했습니다. 이제 마감 작업을 시작합니다.", "\u001B[35m");

        while (true) {
            System.out.println("\u001B[36m===========================================");
            System.out.println("당신의 직업을 선택해주세요:");
            System.out.println("셰프 | 매니저");
            System.out.println("===========================================\u001B[0m");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "셰프":
                	chefOperations();
                    break;
                case "매니저":
                	managerOperations();
                    break;
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", "\u001B[31m");
                    break;
            }
        }
    }

    private void chefOperations() {
        while (true) {
            System.out.println("\u001B[36m===========================================");
            System.out.println("셰프로 선택하셨습니다. 할 일을 선택해주세요:");
            System.out.println("1. 재고 확인");
            System.out.println("2. 직업 선택으로 돌아가기");
            System.out.println("===========================================\u001B[0m");

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
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", "\u001B[31m");
                    break;
            }
        }
    }

    private void managerOperations() {
        while (true) {
            System.out.println("\u001B[36m===========================================");
            System.out.println("매니저로 선택하셨습니다. 할 일을 선택해주세요:");
            System.out.println("1. 피드백 검토");
            System.out.println("2. 재무 관리");
            System.out.println("3. 직업 선택으로 돌아가기");
            System.out.println("9. 프로그램 종료");
            System.out.println("===========================================\u001B[0m");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                    reviewFeedback();
                    break;
                case 2:
                    RevenueAndCost.printFinanceReport();
                    break;
                case 3:
                    return; // 메서드 종료 후 직업 선택으로 돌아감
                case 9:
                    printBanner("프로그램을 종료합니다. 수고하셨습니다!", "\u001B[32m");
                    System.exit(0); // 프로그램 종료
                default:
                    printBanner("잘못된 선택입니다. 다시 시도하세요.", "\u001B[31m");
                    break;
            }
        }
    }

    private void reviewFeedback() {
        Feedback feedback = Feedback.getInstance();
        feedback.setFeedback(); // 피드백 평균값 계산
        System.out.println("\u001B[36m===========================================");
        System.out.println("피드백 검토:");
        System.out.println("음식 평점: " + Feedback.foodRateMean);
        System.out.println("서비스 평점: " + Feedback.serviceRateMean);
        System.out.println("시설 평점: " + Feedback.facilityRateMean);
        System.out.println("===========================================\u001B[0m");
    }

    private void printBanner(String message, String color) {
        System.out.println(color + "===========================================");
        System.out.println(message);
        System.out.println("===========================================" + "\u001B[0m");
    }
}
