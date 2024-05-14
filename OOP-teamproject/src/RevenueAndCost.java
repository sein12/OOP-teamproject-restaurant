import java.util.ArrayList;

public class RevenueAndCost {
    // [황태해장국 정식, 순두부 정식, 뚝배기 불고기 정식, 전복 갈비탕]

    public static int calculateTotalCost(Table table) {
        int totalCost = 0;
        ArrayList<String> orderList = table.getOrderList();
        ArrayList<Integer> orderNumber = table.getOrderNumber();
        for (int i = 0; i < orderList.size(); i++) {
            String item = orderList.get(i);
            int quantity = orderNumber.get(i);

            if (item.equals("황태해장국 정식") || item.equals("순두부 정식") || item.equals("뚝배기 불고기 정식")
                    || item.equals("전복 갈비탕")) {
                totalCost += StockAndCost.getInstance().getCourseCost(item) * quantity;
            } else if (item.equals("탄산음료") || item.equals("술")) {
                totalCost += StockAndCost.getInstance().getDrinkCost(item) * quantity;
            }
        }
        return totalCost;
    }

  //  public static int calculateTotalRevenue(Table table) {
       // return table.getTotalPrice();
  //  }

    public static int calculateNetProfit(Table table) {
        int totalRevenue = calculateTotalRevenue(table);
        int totalCost = calculateTotalCost(table);
        return totalRevenue - totalCost;
    }

    public static void printFinanceReport(Table table) {
        System.out.println("오늘의 총 수익: " + calculateTotalRevenue(table));
        System.out.println("오늘의 총 비용: " + calculateTotalCost(table));
        System.out.println("오늘의 순이익: " + calculateNetProfit(table));
    }
}
