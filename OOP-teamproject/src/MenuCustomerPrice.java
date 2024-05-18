public class MenuCustomerPrice {
    private static MenuCustomerPrice instance; // 싱글톤

    private static final String[] COURSE_MENU = { "황태해장국 정식", "순두부 정식", "뚝배기 불고기 정식", "전복 갈비탕" };
    private static final String[] DRINK_MENU = { "탄산음료", "술" };
    private static final int[] COURSE_PRICE_INT = { 17000, 18000, 19000, 25000 }; // 가격을 정수형으로 변경
    private static final int[] DRINK_PRICE_INT = { 5000, 8000 }; // 가격을 정수형으로 변경

    private MenuCustomerPrice() { // 생성자
    }

    public static MenuCustomerPrice getInstance() {
        if (instance == null) {
            instance = new MenuCustomerPrice();
        }
        return instance;
    }

    public String[] getCourseMenuList() { // 메뉴의 리스트를 반환함
        return COURSE_MENU;
    }
    
    public int getCoursePrice(String menu) { // 메뉴 이름을 parameter로 받아 해당 메뉴의 가격을 int 형식으로 반환.
        switch (menu) {
            case "황태해장국 정식":
                return COURSE_PRICE_INT[0];
            case "순두부 정식":
                return COURSE_PRICE_INT[1];
            case "뚝배기 불고기 정식":
                return COURSE_PRICE_INT[2];
            case "전복 갈비탕":
                return COURSE_PRICE_INT[3];
            default:
                throw new IllegalArgumentException("Please type correct menu!");
        }
    }

    public int[] getCoursePriceInt() { // 메뉴의 가격을 리스트로 반환
        return COURSE_PRICE_INT;
    }

    public String[] getDrinkMenuList() {
        return DRINK_MENU;
    }

    public int getDrinkPrice(String menu) {
        switch (menu) {
            case "탄산음료":
                return DRINK_PRICE_INT[0];
            case "술":
                return DRINK_PRICE_INT[1];
            default:
                throw new IllegalArgumentException("Please type correct menu!");
        }
    }

    public int[] getDrinkPriceInt() {
        return DRINK_PRICE_INT;
    }
}
