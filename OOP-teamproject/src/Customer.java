public class Customer {
    private double cardBalance;
    private double cashBalance;
    private boolean haveCoupon;

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public boolean isHaveCoupon() {
        return haveCoupon;
    }

    public void setHaveCoupon(boolean haveCoupon) {
        this.haveCoupon = haveCoupon;
    }
}
