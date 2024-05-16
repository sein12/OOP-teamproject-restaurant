import java.util.Scanner;

public class Chef {
  // 요리 재고 확인 메소드

  public int getDishStock() {
      System.out.println("요리 별 재고 확인하겠습니다")
      for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
          System.out.println(StockAndCost.DishMenu[i]+"의 재고는 "+StockAndCost.DishStock[i]+"개 남아있습니다");    // for문으로 메뉴별 재고 출력
      }
  }

  // 음료 재고 확인 메소드
  public int getDrinkStock() {
      System.out.println("음료 별 재고 확인하겠습니다")
      for (int i = 0; i < StockAndCost.drinkMenu.length; i++) {
          System.out.println(StockAndCost.drinkMenu[i]+"의 재고는 "+StockAndCost.drinkStock[i]+"개 남아있습니다");    // for문으로 메뉴별 재고 출력
      }
  }

  // 요리 재고 수정 메소드
  public int modifyDishStock() {
      String answer = scanner.nextLine();
      String count = scanner.nextInt();
      boolean countUnchanged = True;
      System.out.println("요리의 재고를 수정하시겠습니까?(추가/감소)를 입력해주세요.: ");
      answer = scanner.nextLine();

      if (answer.equals("추가")){
          System.out.println("요리의 재고를 추가하겠습니다.");
          for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
              System.out.println("현재 "+StockAndCost.DishMenu[i]+"의 재고는 "+StockAndCost.DishStock[i]+"개 남아있습니다. "+ StockAndCost.DishMenu[i]+"재고를 몇개 추가할까요?");    
              count = scanner.nextInt();    // StockAndCost.DishMenu[i]의 재고를 count만큼 추가
              FinanceCal.expenses += count*StockAndCost.DishCost[i];    // update한 재고 개수의 가격만큼 지출에 update
              StockAndCost.DishStock[i] += count;    // update한 재고 개수만큼 재고에 update
              System.out.println(StockAndCost.DishMenu[i]+"의 재고가 성공적으로 추가되었습니다. 현재"+StockAndCost.DishMenu[i]+"의 재고는 "+StockAndCost.DishStock[i]+"개 남아있습니다.");    
          }
      }
      else if(answer.equals("감소")) {
          System.out.println("요리의 재고를 감소시키겠습니다.");
          for (int i = 0; i < StockAndCost.DishMenu.length; i++) {
              countUnchanged = true;
              while(countUnchanged){    // 값이 바뀌지 않았으면 무한 반복
                  System.out.println("현재 "+StockAndCost.DishMenu[i]+"의 재고는 "+StockAndCost.DishStock[i]+"개 남아있습니다. "+StockAndCost.DishMenu[i]+"재고를 몇개 감소시킬까요?");    
                  count = scanner.nextInt();    // StockAndCost.courseMenu[i]의 재고를 count만큼 추가
                  if (count<=StockAndCost.DishStock[i] && count>=0){    // count가 0이상이고 재고와 같거나 보다 적을 때
                      StockAndCost.DishStock[i] -= count;    // update한 재고 개수만큼 재고에 update
                      System.out.println(StockAndCost.DishMenu[i]+"의 재고가 성공적으로 감소되었습니다. 현재 "+StockAndCost.DishMenu[i]+"의 재고는 "+StockAndCost.DishStock[i]+"개 남아있습니다.");  
                      countUnchanged = false;    //값이 바뀌었음 == false
                  }  
                  else if (count>StockAndCost.DishStock[i]) {
                      System.out.println("현재 재고보다 많이 재고를 감소시킬 수 없습니다. "+StockAndCost.DishMenu[i]+"에 대해 감소시킬 재고의 개수를 올바르게 입력해주세요")
                  }
                  else if(count<0) {
                      System.out.println("음수만큼 재고를 감소시킬 수는 없습니다. "+StockAndCost.DishMenu[i]+"에 대해 감소시킬 재고의 개수를(절대값을) 올바르게 입력해주세요")
                  }
              }

          }            
      }
      // 음료 재고 수정 메소드
  public int modifyDrinkStock() {
      String answer = scanner.nextLine();
      String count = scanner.nextInt();
      boolean countUnchanged = True;
      System.out.println("음료의 재고를 수정하시겠습니까?(추가/감소)를 입력해주세요.: ");
      answer = scanner.nextLine();

      if (answer.equals("추가")){
          System.out.println("음료의 재고를 추가하겠습니다.");
          for (int i = 0; i < StockAndCost.drinkMenu.length; i++) {
              System.out.println("현재 "+StockAndCost.drinkMenu[i]+"의 재고는 "+StockAndCost.drinkStock[i]+"개 남아있습니다. "+StockAndCost.drinkMenu[i]+"재고를 몇개 추가할까요?");    
              count = scanner.nextInt();    // StockAndCost.drinkMenu[i]의 재고를 count만큼 추가
              FinanceCal.expenses += count*StockAndCost.drinkCost[i];    // update한 재고 개수의 가격만큼 지출에 update
              StockAndCost.drinkStock[i] += count;    // update한 재고 개수만큼 재고에 update
              System.out.println(StockAndCost.drinkMenu[i]+"의 재고가 성공적으로 추가되었습니다. 현재"+StockAndCost.drinkMenu[i]+"의 재고는 "+StockAndCost.drinkStock[i]+"개 남아있습니다.");    
          }    // for문 
      }    // if
      else if(answer.equals("감소")) {
          System.out.println("음료의 재고를 감소시키겠습니다.");
          for (int i = 0; i < StockAndCost.drinkMenu.length; i++) {
              countUnchanged = true;
              while(countUnchanged){    // 값이 바뀌지 않았으면 무한 반복
                  System.out.println("현재 "+StockAndCost.drinkMenu[i]+"의 재고는 "+StockAndCost.drinkStock[i]+"개 남아있습니다. "+StockAndCost.drinkMenu[i]+"재고를 몇개 감소시킬까요?");    
                  count = scanner.nextInt();    // StockAndCost.drinkMenu[i]의 재고를 count만큼 추가
                  if (count<=StockAndCost.drinkStock[i] && count>=0){    // count가 0이상이고 재고와 같거나 보다 적을 때
                      StockAndCost.drinkStock[i] -= count;    // update한 재고 개수만큼 재고에 update
                      System.out.println(StockAndCost.drinkMenu[i]+"의 재고가 성공적으로 감소되었습니다. 현재 "+StockAndCost.drinkMenu[i]+"의 재고는 "+StockAndCost.drinkStock[i]+"개 남아있습니다.");  
                      countUnchanged = false;    // 값이 바뀌었음.
                  }  
                  else if (count>StockAndCost.drinkStock[i]) {
                      System.out.println("현재 재고보다 많이 재고를 감소시킬 수 없습니다. "+StockAndCost.drinkMenu[i]+"에 대해 감소시킬 재고의 개수를 올바르게 입력해주세요")
                  }
                  else if(count<0) {
                      System.out.println("음수만큼 재고를 감소시킬 수는 없습니다. "+StockAndCost.drinkMenu[i]+"에 대해 감소시킬 재고의 개수를(절대값을) 올바르게 입력해주세요")
                  }
              }// while닫기

          }   // for문 닫기
      }    // else if 닫기
  }    //modifyDrinkStock() 닫기기


}
