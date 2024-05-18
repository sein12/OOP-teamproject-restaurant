import java.util.ArrayList;
import java.util.Random;

public class Table {
    private int[] orderList;
    private int totalPrice;
    private boolean isAvailable;
    static boolean isOccupied;
    
    public Table() {
        orderList = new int[]{0, 0, 0, 0, 0, 0}; //[황태해장국 정식, 순두부 정식, 뚝배기 불고기 정식, 전복 갈비탕, 탄산음료, 술]
        totalPrice = 0;
        isAvailable = true;
    }

    public void orderUpdated(String customerOrder, int number) {
        if (number >= 0) {
            switch (customerOrder) {
                case "황태해장국 정식":
                    orderList[0] = number;
                    break;

                case "순두부 정식":
                    orderList[1] = number;
                    break;

                case "뚝배기 불고기 정식":
                    orderList[2] = number;
                    break;
                    
                case "전복 갈비탕":
                    orderList[3] = number;
                    break;
                    
                case "탄산음료":
                    orderList[4] = number;
                    break;
                    
                case "술":
                    orderList[5] = number;
                    break;
                    
                default:
                    System.out.println("Please type correct menu!");
                    break;
            }
        } else {
            System.out.println("Number must be positive or zero");
        }
    }

    public void updateTotalPrice() {
        totalPrice = 0;
        totalPrice += StockAndCost.getInstance().getDishPriceInt("황태해장국 정식") * orderList[0];
        totalPrice += StockAndCost.getInstance().getDishPriceInt("순두부 정식") * orderList[1];
        totalPrice += StockAndCost.getInstance().getDishPriceInt("뚝배기 불고기 정식") * orderList[2];
        totalPrice += StockAndCost.getInstance().getDishPriceInt("전복 갈비탕") * orderList[3];
        totalPrice += StockAndCost.getInstance().getDrinkPriceInt("탄산음료") * orderList[4];
        totalPrice += StockAndCost.getInstance().getDrinkPriceInt("술") * orderList[5];
    }
        
    

    public void reset() { // 결제가 완료된 후 테이블 초기화
        totalPrice = 0;
        orderList = new int[]{0, 0, 0, 0, 0, 0};
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int[] getOrderList() {
        return orderList;
    }

    /*
     * public int[] getOrderNumber() {
        return orderNumber;
        }
    */
//-----------
  //  public ArryList<String> getOrderList() {
  //      return new ArrayList<>(orderList);
  //  }

  //  public ArrayList<Integer> getOrderNumber() {
  //      return new ArrayList<>(orderNumber);
  //  }

  //  public int getTotalPrice() {
  //      return totalPrice;
  //  }
    //-------------

    public void isSeatOccupiedRandom() {
        // 랜덤한 참/거짓 값을 생성하여 시간에 따른 자리 차있는지 여부 확인
        Random random = new Random();
        boolean randomValue = random.nextBoolean();
        isAvailable = randomValue;
        Hall.getInstance().updateSeat(0, randomValue);

        isOccupied = random.nextBoolean(); // static한 isOccupied가 random.nextBoolean() 값 받음
    }

    private void seatOccupied(Boolean x) { // seat available 여부를 테이블 필드와 hall의 공간 리스트인 seatList에 수동 업데이트
        isAvailable = x;
        Hall.getInstance().updateSeat(0, x);
    }
}
    
