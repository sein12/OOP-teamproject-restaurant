import java.util.Scanner;

public class Preopen {
  public static Preopen instance;
  
  Chef chef = new Chef();
  Manager manager = new Manager();
  Server server = new Server();

  
    public void chooseJob(){
      Scanner scanner = new Scanner(System.in);

      System.out.println("당신은 어떤 직업을 가지고 계십니까?  *영업 시작을 원하신다면 2. 매니저 선택*");
      System.out.println("1. 셰프");
      System.out.println("2. 매니저");
      System.out.println("3. 손님");
      
      int choice = scanner.nextInt();
      
      switch (choice) {
          case 1:
              chefJob();
              break;
          case 2:
              managerJob();
              break;
          case 3:
              guestJob();
              break;
          default:
              System.out.println("잘못된 선택입니다. 다시 시도하세요.");
              chooseJob(); // 재귀 호출로 다시 선택하도록 함
              break;
      }
    }  
  
  public void chefJob() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("셰프로 선택하셨습니다. 주방으로 이동합니다.");
    System.out.println("1. 재고 확인");
    System.out.println("2. 재고 수정");
    System.out.println("3. 직업 선택으로 돌아가기");
      
    int choice = scanner.nextInt();

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
            chooseJob();
        default:
            System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            chefJob(); // 재귀 호출로 다시 선택하도록 함
            break;
    }
  }

  public void managerJob() {
      Scanner scanner = new Scanner(System.in);

    System.out.println("매니저로 선택하셨습니다. 매장 관리 모드로 이동합니다.");
      System.out.println("1. 재무 관리");
      System.out.println("2. 오늘의 예약");
      System.out.println("3. 직업 선택으로 돌아가기");
      System.out.println("9. 매장 오픈");

      int choice = scanner.nextInt();

      switch (choice) {
          case 1:
            chef.getDishStock();
            chef.getDrinkStock();
              break;
          case 2:
              managerJob();
              break;
          case 3:
              chooseJob();
          default:
              System.out.println("잘못된 선택입니다. 다시 시도하세요.");
              chefJob(); // 재귀 호출로 다시 선택하도록 함
              break;
      }
  }

  public void guestJob() {
      System.out.println("손님으로 선택하셨습니다. 예약 시스템으로 이동합니다.");
  }
}
