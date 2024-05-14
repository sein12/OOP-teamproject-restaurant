import java.util.ArrayList;

public class Table {
    private int[] orderList;
    private int totalPrice;
    private boolean isAvailable;

    public Table() {
        orderList = [0,0,0,0,0,0]; // [황태해장국 정식, 순두부 정식, 뚝배기 불고기 정식, 전북 갈비탕, 탄산음료, 술] fixed index
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
        for (int i = 0; i < orderList.size(); i++) {
            if (item.equals("황태해장국 정식")) {
                totalPrice += StockAndCost.getInstance().getDishPriceInt(item) * orderList[0];
            } else if (item.equals("순두부 정식")) {
                totalPrice += StockAndCost.getInstance().getDishPriceInt(item) * orderList[1];
            } else if (item.equals("뚝배기 불고기 정식")) {
                totalPrice += StockAndCost.getInstance().getDishPriceInt(item) * orderList[2];
            } else if (item.equals("전복 갈비탕")) {
                totalPrice += StockAndCost.getInstance().getDishPriceInt(item) * orderList[3];
            } else if (item.equals("탄산음료")) {
                totalPrice += StockAndCost.getInstance().getDrinkPriceInt(item) * orderList[4];
            } else if (item.equals("술")) {
                totalPrice += StockAndCost.getInstance().getDrinkPriceInt(item) * orderList[5];
            }
        }
    }

    public void resetTotalPrice() {
        totalPrice = 0;
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

    public ArrayList<String> getOrderList() {
        return orderList;
    }

    public ArrayList<Integer> getOrderNumber() {
        return orderNumber;
    }
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

    private boolean isSeatOccupiedRandom() {
        // 랜덤한 참/거짓 값을 생성하여 자리가 차있는지 여부확인
        Random random = new Random();
        randomValue = random.nextBoolean();
        isAvailable = randomValue;
        Hall.getInstance().updateSeat(0, randomValue);
        
        
        return random.nextBoolean();
    }

    public void seatProtocol() {
        boolean isOccupied = isSeatOccupiedRandom();

        if (isOccupied) {
            // 안내사항을 어떻게 할 것인지
            System.out.println("죄송합니다. 남아있는 자리가 없습니다. 잠시만 기다려주세요.");
        } else {
            System.out.println("현재 남아있는 좌석이 있습니다. 안내드리겠습니다.");
        }
    }

    // public void setAvailable(boolean available) {
    //     isAvailable = available;
    }
    
}
