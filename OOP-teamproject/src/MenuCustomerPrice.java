public class MenuCustomerPrice {
    private static MenuCustomerPrice instance; // 싱글톤

    static String[] courseMenu = { "황태해장국 정식", "순두부 정식", "뚝배기 불고기 정식", "전복 갈비탕" };
    static String[] drinkMenu = { "탄산음료", "술" };
    static int[] coursePriceInt = { 17000, 18000, 19000, 25000 }; // 가격을 정수형으로 변경
    static int[] drinkPriceInt = { 5000, 8000 }; // 가격을 정수형으로 변경

    private MenuCustomerPrice() { // 생성자
    }

    public static synchronized MenuCustomerPrice getInstance() {
        if (instance == null) {
            instance = new MenuCustomerPrice();
        }
        return instance;
    }

    public String[] getCourseMenuList() { // 메뉴의 리스트를 반환함
        return courseMenu;
    }

    public int getCoursePrice(String menu) { // 메뉴 이름을 parameter로 받아 해당 메뉴의 가격을 int 형식으로 반환.
        int returnValue = 0;
        switch (menu) {
            case "황태해장국 정식":
                returnValue = coursePriceInt[0];
                break;
            case "순두부 정식":
                returnValue = coursePriceInt[1];
                break;
            case "뚝배기 불고기 정식":
                returnValue = coursePriceInt[2];
                break;
            case "전복 갈비탕":
                returnValue = coursePriceInt[3];
                break;
            default:
                System.out.println("Please type correct menu!");
                break;
        }
        return returnValue;
    }

    public int[] getCoursePriceInt() { // 메뉴의 가격을 리스트로 반환
        return coursePriceInt;
    }

    public String[] getDrinkMenuList() {
        return drinkMenu;
    }

    public int getDrinkPrice(String menu) {
        int returnValue = 0;
        switch (menu) {
            case "탄산음료":
                returnValue = drinkPriceInt[0];
                break;
            case "술":
                returnValue = drinkPriceInt[1];
                break;
            default:
                System.out.println("Please type correct menu!");
                break;
        }
        return returnValue;
    }

    public int[] getDrinkPriceInt() {
        return drinkPriceInt;
    }
}
