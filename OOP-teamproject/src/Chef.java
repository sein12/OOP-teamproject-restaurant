import java.util.Scanner;

public class Chef {
    private Scanner scanner = new Scanner(System.in);

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    // 요리 재고 확인 메소드
    public void getDishStock() {
        printBanner("요리 별 재고 확인하겠습니다", GREEN);
        for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
            System.out.println("현재 " + CYAN + StockAndCost.DishMenu[i] + RESET + "의 재고는 " + YELLOW + StockAndCost.DishStock[i] + "개" + RESET + " 남아있습니다.");
        }
    }

    // 음료 재고 확인 메소드
    public void getDrinkStock() {
        printBanner("음료 별 재고 확인하겠습니다", GREEN);
        for (int i = 0; i < StockAndCost.drinkMenu.length; i++) {
            System.out.println("현재 " + CYAN + StockAndCost.drinkMenu[i] + RESET + "의 재고는 " + YELLOW + StockAndCost.drinkStock[i] + "개" + RESET + " 남아있습니다.");
        }
    }

    public void modifyDishStock() {
        printBanner("요리의 재고를 수정하시겠습니까? (추가/감소)를 입력해주세요.", PURPLE);
        String answer = scanner.nextLine();

        if ("추가".equals(answer)) {
            printBanner("요리의 재고를 추가하겠습니다.", GREEN);
            for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
                System.out.println("현재 " + CYAN + StockAndCost.DishMenu[i] + RESET + "의 재고는 " + YELLOW + StockAndCost.DishStock[i] + "개" + RESET + " 남아있습니다.");
                System.out.print(StockAndCost.DishMenu[i] + " 재고를 몇 개 추가할까요?: ");
                
                int count = scanner.nextInt();
                scanner.nextLine(); // 남아있는 개행 문자 처리
                
                RevenueAndCost.expenses += count * StockAndCost.DishCost[i]; // update한 재고 개수의 가격만큼 지출에 update
                StockAndCost.DishStock[i] += count; // update한 재고 개수만큼 재고에 update
                
                System.out.println(StockAndCost.DishMenu[i] + "의 재고가 성공적으로 추가되었습니다. 현재 " + CYAN + StockAndCost.DishMenu[i] + RESET + "의 재고는 " + GREEN + StockAndCost.DishStock[i] + "개" + RESET + " 남아있습니다.");
                printDivider(PURPLE);
            }
        } else if ("감소".equals(answer)) {
            printBanner("요리의 재고를 감소시키겠습니다.", RED);
            for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
                boolean countUnchanged = true;
                while (countUnchanged) { // 값이 바뀌지 않았으면 무한 반복
                    System.out.println("현재 " + CYAN + StockAndCost.DishMenu[i] + RESET + "의 재고는 " + YELLOW + StockAndCost.DishStock[i] + "개" + RESET + " 남아있습니다.");
                    System.out.print(StockAndCost.DishMenu[i] + " 재고를 몇 개 감소시킬까요?: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // 남아있는 개행 문자 처리
                    
                    if (count <= StockAndCost.DishStock[i] && count >= 0) { // count가 0 이상이고 재고와 같거나 보다 적을 때
                        StockAndCost.DishStock[i] -= count; // update한 재고 개수만큼 재고에 update
                        System.out.println(StockAndCost.DishMenu[i] + "의 재고가 성공적으로 감소되었습니다. 현재 " + CYAN + StockAndCost.DishMenu[i] + RESET + "의 재고는 " + GREEN + StockAndCost.DishStock[i] + "개" + RESET + " 남아있습니다.");
                        printDivider(PURPLE);
                        countUnchanged = false; // 값이 바뀌었음 == false
                    } else if (count > StockAndCost.DishStock[i]) {
                        printBanner("현재 재고보다 많이 재고를 감소시킬 수 없습니다. " + StockAndCost.DishMenu[i] + "에 대해 감소시킬 재고의 개수를 올바르게 입력해주세요", RED);
                    } else if (count < 0) {
                        printBanner("음수만큼 재고를 감소시킬 수는 없습니다. " + StockAndCost.DishMenu[i] + "에 대해 감소시킬 재고의 개수를(절대값을) 올바르게 입력해주세요", RED);
                    }
                }
            }
        }
    }

    public void modifyDrinkStock() {
        printBanner("음료의 재고를 수정하시겠습니까? (추가/감소)를 입력해주세요.", PURPLE);
        String answer = scanner.nextLine();

        if ("추가".equals(answer)) {
            printBanner("음료의 재고를 추가하겠습니다.", GREEN);
            for (int i = 0; i < StockAndCost.drinkMenu.length; i++) {
                System.out.println("현재 " + CYAN + StockAndCost.drinkMenu[i] + RESET + "의 재고는 " + YELLOW + StockAndCost.drinkStock[i] + "개" + RESET + " 남아있습니다.");
                System.out.print(StockAndCost.drinkMenu[i] + " 재고를 몇 개 추가할까요?: ");
                int count = scanner.nextInt();
                scanner.nextLine(); // 남아있는 개행 문자 처리
                
                RevenueAndCost.expenses += count * StockAndCost.drinkCost[i]; // update한 재고 개수의 가격만큼 지출에 update
                StockAndCost.drinkStock[i] += count; // update한 재고 개수만큼 재고에 update
                
                System.out.println(StockAndCost.drinkMenu[i] + "의 재고가 성공적으로 추가되었습니다. 현재 " + CYAN + StockAndCost.drinkMenu[i] + RESET + "의 재고는 " + GREEN + StockAndCost.drinkStock[i] + "개" + RESET + " 남아있습니다.");
                printDivider(PURPLE);
            }
        } else if ("감소".equals(answer)) {
            printBanner("음료의 재고를 감소시키겠습니다.", RED);
            for (int i = 0; i < StockAndCost.drinkMenu.length; i++) {
                boolean countUnchanged = true;
                while (countUnchanged) { // 값이 바뀌지 않았으면 무한 반복
                    System.out.println("현재 " + CYAN + StockAndCost.drinkMenu[i] + RESET + "의 재고는 " + YELLOW + StockAndCost.drinkStock[i] + "개" + RESET + " 남아있습니다.");
                    System.out.print(StockAndCost.drinkMenu[i] + " 재고를 몇 개 감소시킬까요?: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // 남아있는 개행 문자 처리
                    
                    if (count <= StockAndCost.drinkStock[i] && count >= 0) { // count가 0 이상이고 재고와 같거나 보다 적을 때
                        StockAndCost.drinkStock[i] -= count; // update한 재고 개수만큼 재고에 update
                        System.out.println(StockAndCost.drinkMenu[i] + "의 재고가 성공적으로 감소되었습니다. 현재 " + CYAN + StockAndCost.drinkMenu[i] + RESET + "의 재고는 " + GREEN + StockAndCost.drinkStock[i] + "개" + RESET + " 남아있습니다.");
                        printDivider(PURPLE);
                        countUnchanged = false; // 값이 바뀌었음.
                    } else if (count > StockAndCost.drinkStock[i]) {
                        printBanner("현재 재고보다 많이 재고를 감소시킬 수 없습니다. " + StockAndCost.drinkMenu[i] + "에 대해 감소시킬 재고의 개수를 올바르게 입력해주세요", RED);
                    } else if (count < 0) {
                        printBanner("음수만큼 재고를 감소시킬 수는 없습니다. " + StockAndCost.drinkMenu[i] + "에 대해 감소시킬 재고의 개수를(절대값을) 올바르게 입력해주세요", RED);
                    }
                }
            }
        }
    }

    private void printBanner(String message, String color) {
        System.out.println(color + BOLD + "========================================================================================");
        System.out.println(message);
        System.out.println("========================================================================================" + RESET);
    }

    private void printDivider(String color) {
        System.out.println(color + "========================================================================================" + RESET);
    }
}
