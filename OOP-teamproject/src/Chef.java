import java.util.Scanner;
import java.util.List;

public class Chef {
    private Scanner scanner = new Scanner(System.in);
  
    // 요리 재고 확인 메소드
    public void getDishStock() { // return 타입을 void로 수정
        System.out.println("요리 별 재고 확인하겠습니다");
        for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
            System.out.println(StockAndCost.DishMenu[i] + "의 재고는 " + StockAndCost.DishStock[i] + "개 남아있습니다");
        }
    }

    // 음료 재고 확인 메소드
    public void getDrinkStock() { // return 타입을 void로 수정
        System.out.println("음료 별 재고 확인하겠습니다");
        for (int i = 0; i < StockAndCost.drinkMenu.length; i++) { // 배열로 변경했으므로 .length로 수정
            System.out.println(StockAndCost.drinkMenu[i] + "의 재고는 " + StockAndCost.drinkStock[i] + "개 남아있습니다");
        }
    }

    public void modifyDishStock() { // return 타입을 void로 수정
        System.out.println("요리의 재고를 수정하시겠습니까?(추가/감소)를 입력해주세요.: ");
        String answer = scanner.nextLine();

        if ("추가".equals(answer)) {
            System.out.println("요리의 재고를 추가하겠습니다.");
            for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
                System.out.println("현재 " + StockAndCost.DishMenu[i] + "의 재고는 " + StockAndCost.DishStock[i] + "개 남아있습니다. " + StockAndCost.DishMenu[i] + " 재고를 몇 개 추가할까요?");
                
                int count = scanner.nextInt();
                scanner.nextLine(); // 남아있는 개행 문자 처리
                
                RevenueAndCost.expenses += count * StockAndCost.DishCost[i]; // update한 재고 개수의 가격만큼 지출에 update
                StockAndCost.DishStock[i] += count; // update한 재고 개수만큼 재고에 update
                
                System.out.println(StockAndCost.DishMenu[i] + "의 재고가 성공적으로 추가되었습니다. 현재 " + StockAndCost.DishMenu[i] + "의 재고는 " + StockAndCost.DishStock[i] + "개 남아있습니다.");
                System.out.println("=========================================================================================");
            }
        } else if ("감소".equals(answer)) {
            System.out.println("요리의 재고를 감소시키겠습니다.");
            
            for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
                boolean countUnchanged = true;
                
                while (countUnchanged) { // 값이 바뀌지 않았으면 무한 반복
                    System.out.println("현재 " + StockAndCost.DishMenu[i] + "의 재고는 " + StockAndCost.DishStock[i] + "개 남아있습니다. " + StockAndCost.DishMenu[i] + " 재고를 몇 개 감소시킬까요?");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // 남아있는 개행 문자 처리
                    
                    if (count <= StockAndCost.DishStock[i] && count >= 0) { // count가 0 이상이고 재고와 같거나 보다 적을 때
                        StockAndCost.DishStock[i] -= count; // update한 재고 개수만큼 재고에 update
                        System.out.println(StockAndCost.DishMenu[i] + "의 재고가 성공적으로 감소되었습니다. 현재 " + StockAndCost.DishMenu[i] + "의 재고는 " + StockAndCost.DishStock[i] + "개 남아있습니다.");
                        countUnchanged = false; // 값이 바뀌었음 == false
                    } else if (count > StockAndCost.DishStock[i]) {
                        System.out.println("현재 재고보다 많이 재고를 감소시킬 수 없습니다. " + StockAndCost.DishMenu[i] + "에 대해 감소시킬 재고의 개수를 올바르게 입력해주세요");
                    } else if (count < 0) {
                        System.out.println("음수만큼 재고를 감소시킬 수는 없습니다. " + StockAndCost.DishMenu[i] + "에 대해 감소시킬 재고의 개수를(절대값을) 올바르게 입력해주세요");
                    }
                }
            }
        }
    }
    
 // 음료 재고 수정 메소드
    public void modifyDrinkStock() { // return 타입을 void로 수정
        System.out.println("음료의 재고를 수정하시겠습니까?(추가/감소)를 입력해주세요.: ");
        String answer = scanner.nextLine();

        if ("추가".equals(answer)) {
            System.out.println("음료의 재고를 추가하겠습니다.");
            
            for (int i = 0; i < StockAndCost.drinkMenu.length; i++) { // 배열로 변경했으므로 .length로 수정
                System.out.println("현재 " + StockAndCost.drinkMenu[i] + "의 재고는 " + StockAndCost.drinkStock[i] + "개 남아있습니다. " + StockAndCost.drinkMenu[i] + " 재고를 몇 개 추가할까요?");
                int count = scanner.nextInt();
                scanner.nextLine(); // 남아있는 개행 문자 처리
                
                RevenueAndCost.expenses += count * StockAndCost.drinkCost[i]; // update한 재고 개수의 가격만큼 지출에 update
                StockAndCost.drinkStock[i] += count; // update한 재고 개수만큼 재고에 update
                
                System.out.println(StockAndCost.drinkMenu[i] + "의 재고가 성공적으로 추가되었습니다. 현재 " + StockAndCost.drinkMenu[i] + "의 재고는 " + StockAndCost.drinkStock[i] + "개 남아있습니다.");
            }
        } else if ("감소".equals(answer)) {
            System.out.println("음료의 재고를 감소시키겠습니다.");
            
            for (int i = 0; i < StockAndCost.drinkMenu.length; i++) { // 배열로 변경했으므로 .length로 수정
                boolean countUnchanged = true;
                
                while (countUnchanged) { // 값이 바뀌지 않았으면 무한 반복
                    System.out.println("현재 " + StockAndCost.drinkMenu[i] + "의 재고는 " + StockAndCost.drinkStock[i] + "개 남아있습니다. " + StockAndCost.drinkMenu[i] + " 재고를 몇 개 감소시킬까요?");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // 남아있는 개행 문자 처리
                    
                    if (count <= StockAndCost.drinkStock[i] && count >= 0) { // count가 0 이상이고 재고와 같거나 보다 적을 때
                        StockAndCost.drinkStock[i] -= count; // update한 재고 개수만큼 재고에 update
                        System.out.println(StockAndCost.drinkMenu[i] + "의 재고가 성공적으로 감소되었습니다. 현재 " + StockAndCost.drinkMenu[i] + "의 재고는 " + StockAndCost.drinkStock[i] + "개 남아있습니다.");
                        countUnchanged = false; // 값이 바뀌었음.
                    } else if (count > StockAndCost.drinkStock[i]) {
                        System.out.println("현재 재고보다 많이 재고를 감소시킬 수 없습니다. " + StockAndCost.drinkMenu[i] + "에 대해 감소시킬 재고의 개수를 올바르게 입력해주세요");
                    } else if (count < 0) {
                        System.out.println("음수만큼 재고를 감소시킬 수는 없습니다. " + StockAndCost.drinkMenu[i] + "에 대해 감소시킬 재고의 개수를(절대값을) 올바르게 입력해주세요");
                    }
                }
            }
        }
    }


}
