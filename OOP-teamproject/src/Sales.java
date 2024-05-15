import java.util.Scanner;
import java.util.ArrayList;

public class Sales {
  public int calculateSales(ArrayList<String> orderList) {
    MenuCustomerPrice menu = MenuCustomerPrice.getInstance();
    RevenueAndCost.revenue = 0;

    for (String item : orderList) {
      if (menu.getCoursePrice(item) > 0) {
        RevenueAndCost.revenue += menu.getCoursePrice(item);
      } else if (menu.getDrinkPrice(item) > 0) {
        RevenueAndCost.revenue += menu.getDrinkPrice(item);
      }
    }

    return RevenueAndCost.revenue;

  }

  public void printSalesReport(ArrayList<String> orderList) {
    System.out.println("총 매출: " + RevenueAndCost.revenue + "원");
  }
}
