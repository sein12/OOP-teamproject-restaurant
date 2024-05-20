public class RevenueAndCost {
    static int revenue = Sales.Sales; // 수입(결제 후 수입 업데이트, 정우)
    static int expenses; // 지출(재고 추가 과정에서 지출 업데이트, 예은)
    
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";

    public static int calculateNetProfit() { 
        int netProfit = revenue - expenses;
        return netProfit;
    }

    public static void printFinanceReport() {
        int netProfit = calculateNetProfit(); // netProfit을 계산
        System.out.println(PURPLE + BOLD + "===========================================" + RESET);
        System.out.println("오늘의 총 수익: " + GREEN + revenue + RESET);
        System.out.println("오늘의 총 지출: " + RED + expenses + RESET);
        System.out.println("오늘의 순이익: " + CYAN + netProfit + RESET); // netProfit 출력
        System.out.println(PURPLE + BOLD + "===========================================" + RESET);
    }
}
