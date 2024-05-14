import java.util.Scanner;
import java.util.ArrayList;

public class Payment {
    Scanner scanner = new Scanner(System.in);
    private static Payment instance;

    private Payment() {
    }

    public static Payment getInstance() {
        if (instance == null) {
            instance = new Payment();
        }
        return instance;
    }

    private int cardBalance;
    private int cashBalance;

    // cardBalance의 getter 메서드
    public int getCardBalance() {
        return cardBalance;
    }

    // cardBalance의 setter 메서드
    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    // cashBalance의 getter 메서드
    public int getCashBalance() {
        return cashBalance;
    }

    // cashBalance의 setter 메서드
    public void setCashBalance(int cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void payWithCardAndCash() {
        Table table = new Table();
        int totalPrice = Table.getTotalPrice();
        int dishCost = StockAndCost.DishCost;// totalPrice 변수의 값은 어디서 오는지 확인 필요
        int drinkCost = StockAndCost.drinkCost;

        while (totalPrice > 0) {
            System.out.println("결제하실 금액은 " + totalPrice + "원 입니다.");
            System.out.println("어떤 결제 수단을 사용하시겠습니까?");
            String cardOrCash = scanner.next();

            if (cardOrCash.equalsIgnoreCase("카드")) {
                System.out.println("지불하실 금액을 입력해주세요");
                float discharge = scanner.nextFloat(); // 사용자 입력 받기

                // CardBalance 변수가 어디서 오는지 확인 필요
                if (cardBalance >= discharge && totalPrice >= discharge) {
                    cardBalance -= discharge;
                    totalPrice -= discharge;
                    // DB 업데이트 코드 추가
                    System.out.println("해당 금액 결제 되었습니다.");
                } else if (cardBalance < discharge && totalPrice >= discharge) {
                    System.out.println("카드 잔액이 부족하여 결제를 완료할 수 없습니다.");
                } else {
                    System.out.println("지불하실 금액을 초과하여 결제할 수 없습니다.");
                }
            }

            if (cardOrCash.equalsIgnoreCase("현금")) {
                System.out.println("지불하실 금액을 입력");
                float payment = scanner.nextFloat(); // 사용자 입력 받기

                // 현금보유량 변수가 어디서 오는지 확인 필요
                if (cashBalance >= payment && totalPrice >= payment) {
                    cashBalance -= payment;
                    totalPrice -= payment;
                    // DB 업데이트 코드 추가
                    System.out.println("해당 금액 결제 되었습니다.");
                } else if (cashBalance < payment && totalPrice >= payment) {
                    System.out.println("잔액이 부족하여 결제를 완료할 수 없습니다.");
                } else {
                    System.out.println("지불하실 금액을 초과하여 결제할 수 없습니다.");
                }
            }
        }

        System.out.println("결제 완료되셨습니다. 이용해주셔서 감사합니다. 안녕히 가십시오.");
    }
}