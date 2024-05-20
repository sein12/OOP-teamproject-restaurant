public class CardPay implements Pay {
    private static CardPay instance;
    private CouponCheckerandDiscount checker;
    private Server server; // 서버 인스턴스를 필드로 추가
    private Customer customer;

    private CardPay() {
        checker = new CouponCheckerandDiscount();
    }

    public static synchronized CardPay getInstance() {
        if (instance == null) {
            instance = new CardPay();
        }
        return instance;
    }

    public void setServer(Server server) {
        this.server = server; // 서버 인스턴스를 설정하는 메서드
    }

    public void pay(double price) {
        Customer currentCustomer = server.getCurrentCustomer(); // 서버 인스턴스를 통해 현재 고객을 가져옴
        double cardBalance = currentCustomer.getCardBalance();

        while (price > 0) {
            System.out.println("결제하시겠습니까?");

            if (cardBalance >= price) {
                System.out.println("결제하실 금액은 " + price + "원 입니다.");
                boolean hasCoupon = customer.isHaveCoupon();
                if (hasCoupon) {
                    price = checker.applyDiscount(price, hasCoupon);
                }
                Sales.Sales += price;
                cardBalance -= price;
                currentCustomer.setCardBalance(cardBalance); // 업데이트된 잔액 설정
                System.out.println("카드로 결제가 완료되었습니다.");
                break;
            } else {
                System.out.println("카드 잔액이 부족하여 결제를 완료할 수 없습니다.");
                break;
            }
        }
    }
}
