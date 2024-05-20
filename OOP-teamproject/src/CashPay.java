public class CashPay implements Pay {
    private static CashPay instance;
    private double cashBalance; // 고객 현금 값
    CouponCheckerandDiscount checker;

    private CashPay() {
        checker = new CouponCheckerandDiscount();
    }
    
    public static synchronized CashPay getInstance() {
		if (instance == null) {
            instance = new CashPay();
        }
        return instance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public double getCashBalance() {
        return cashBalance;
    }


    private void calculateChange(double cashBalance, double price) {
        double change = cashBalance - price;
        System.out.println("거스름돈은 " + change + "원 입니다.");
    }
    

    public void pay(double price) {
        while (price > 0) {
          System.out.println("결제하시겠습니까?");

          if (cashBalance >= price) {
              System.out.println("결제하실 금액은 "+price+"원 입니다.");
              boolean hasCoupon = checker.askCoupon();
              if (hasCoupon) {
                      checker.applyDiscount(price, hasCoupon);
              }
              cashBalance -= price;   
              Sales.Sales += price;
              System.out.println("현금으로 결제가 완료되었습니다.");
              calculateChange(cashBalance, price);
          } else {
              System.out.println("현금 잔액이 부족하여 결제를 완료할 수 없습니다.");
          }
      }
        }
}
