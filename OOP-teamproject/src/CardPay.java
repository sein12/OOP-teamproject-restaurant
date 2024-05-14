public class CardPay implements Pay {

    private double cardBalance; // 고객 카드값

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    CouponCheckerandDiscount checker = new CouponCheckerandDiscount();

    // 오버라이드
    public void pay(double price) {
        System.out.println("결제하시겠습니까?");
        if (cardBalance >= price) {
            boolean hasCoupon = checker.askCoupon();
            if (hasCoupon) {
                checker.applyDiscount(price, hasCoupon);
            }
            cardBalance -= price;
            System.out.println("카드로 결제가 완료되었습니다.");
        } else {
            System.out.println("카드 잔액이 부족하여 결제를 완료할 수 없습니다.");
        }
    }
}