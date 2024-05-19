import java.util.Scanner;

public class Preopen {
    private Chef chef = new Chef();
    private Manager manager = new Manager();
    private Server server = new Server();
    private ReservationSystem reservationSystem = ReservationSystem.getInstance(); // reservationsEntry 메서드에서 사용
    private Scanner scanner = new Scanner(System.in);

    public boolean openStore = false; // 매장 오픈 여부를 나타내는 플래그
    
    public void chooseJob() {
        while (true) {
            System.out.println("당신의 직업은 무엇입니까?  *영업 시작을 원하신다면 매니저를 선택해주세요.*");
            System.out.println("셰프 | 매니저 | 손님");
            System.out.println("===========================================");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "셰프":
                    System.out.println("셰프로 선택하셨습니다. 주방으로 이동합니다.");
                    chefJob();
                    break;
                case "매니저":
                    System.out.println("매니저로 선택하셨습니다. 매장 관리 모드로 이동합니다.");
                    managerJob();
                    if (openStore) {
                        return; // 매장 오픈 시 메서드를 종료하여 Main으로 돌아감
                    }
                    break;
                case "손님":
                    System.out.println("손님으로 선택하셨습니다. 예약 시스템으로 이동합니다.");
                    guestJob();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    public void chefJob() {
        while (true) {
            System.out.println("===========================================");
            System.out.println("할 일 선택");
            System.out.println("1. 재고 확인");
            System.out.println("2. 재고 수정");
            System.out.println("3. 직업 선택으로 돌아가기");
            System.out.println("===========================================");

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
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    public void managerJob() {
        while (true) {
            System.out.println("===========================================");
            System.out.println("할 일 선택");
            System.out.println("1. 재무 관리");
            System.out.println("2. 오늘의 예약");
            System.out.println("3. 직업 선택으로 돌아가기");
            System.out.println("9. 매장 오픈");
            System.out.println("===========================================");

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
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    public void guestJob() {
        System.out.println("===========================================");
        reservationSystem.selectReservationTime();
    }
}
