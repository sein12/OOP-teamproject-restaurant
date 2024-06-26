public class CashPay implements Pay {
    private static CashPay instance;
    private CouponCheckerandDiscount checker;
    private Server server;

    private CashPay() {
        checker = new CouponCheckerandDiscount();
    }

    public static synchronized CashPay getInstance() {
        if (instance == null) {
            instance = new CashPay();
        }
        return instance;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    private void calculateChange(double cashBalance, double price) {
        double change = cashBalance - price;
        System.out.println("거스름돈은 " + change + "원 입니다.");
    }

    public void pay(double price) {
        Customer currentCustomer = server.getCurrentCustomer();
        double cashBalance = currentCustomer.getCashBalance();

        while (price > 0) {
            System.out.println("결제하시겠습니까?");

            if (cashBalance >= price) {
                System.out.println("결제하실 금액은 " + price + "원 입니다.");
                boolean hasCoupon = currentCustomer.isHaveCoupon();
                if (hasCoupon) {
                    price = checker.applyDiscount(price, hasCoupon);
                }
                cashBalance -= price;
                currentCustomer.setCashBalance(cashBalance); // 업데이트된 잔액 설정
                Sales.Sales += price;
                System.out.println("현금으로 결제가 완료되었습니다.");
                calculateChange(cashBalance, price);
                break;
            } else {
                System.out.println("현금 잔액이 부족하여 결제를 완료할 수 없습니다.");
                server.paying(price);
                break;
            }
        }
    }
}
