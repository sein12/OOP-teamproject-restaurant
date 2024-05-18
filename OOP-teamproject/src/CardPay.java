public class CardPay implements Pay {
    private static CardPay instance;
    private double cardBalance; // 고객 카드값
    private CouponCheckerandDiscount checker;
    
    private CardPay() {
    	checker = new CouponCheckerandDiscount();
    }


    public static synchronized CardPay getInstance() {
		if (instance == null) {
            instance = new CardPay();
        }
        return instance;
    }

    public double getCardBalance() {
        return cardBalance;
    }
    
    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }


    // 오버라이드
    public void pay(double price) {
        System.out.println("결제하시겠습니까?");
        if (cardBalance >= price) {
            boolean hasCoupon = checker.askCoupon();
            if (hasCoupon) {
                checker.applyDiscount(price, hasCoupon);
            }
            Sales.Sales += price;
            cardBalance -= price;
            System.out.println("카드로 결제가 완료되었습니다.");
        } else {
            System.out.println("카드 잔액이 부족하여 결제를 완료할 수 없습니다.");
        }
    }
}
