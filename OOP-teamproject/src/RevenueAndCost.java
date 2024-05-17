public class RevenueAndCost {
    static int revenue = Sales.Sales; // 수입(결제 후 수입 업데이트, 정우)
    static int expenses; // 지출(재고 추가 과정에서 지출 업데이트, 예은)

    public static int calculateNetProfit() { 
        int netProfit = revenue - expenses;
        return netProfit;
    }

    public static void printFinanceReport() {
        int netProfit = calculateNetProfit(); // netProfit을 계산
        System.out.println("오늘의 총 수익: " + revenue);
        System.out.println("오늘의 총 지출: " + expenses);
        System.out.println("오늘의 순이익: " + netProfit); // netProfit 출력
    }
}
