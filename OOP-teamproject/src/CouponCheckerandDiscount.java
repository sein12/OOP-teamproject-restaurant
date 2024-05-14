import java.util.Scanner;
public class CouponCheckerandDiscount {//쿠폰 여부 확인 프로토콜
    public boolean askCoupon() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("쿠폰이 있습니까? (예/아니오): ");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("예");
    }
    public void applyDiscount(double originalPrice, boolean hasCoupon) { //hasCoupon = 쿠폰 여부 <- db 참고
          if (hasCoupon) {
              double discountPrice = originalPrice * 0.1; // 10% 할인
              double discountedPrice = originalPrice - discountPrice;
              System.out.println("10% 할인이 적용되었습니다. 할인된 가격: " + discountedPrice + "원");
          } else {
              System.out.println("쿠폰이 없으므로 할인을 적용할 수 없습니다.");
          }
      }
}
