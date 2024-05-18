public class StockAndCost {
    private static StockAndCost instance;
    // [황태해장국 정식, 순두부 정식, 뚝배기 불고기 정식, 전복 갈비탕]
    static String[] DishMenu = { "황태해장국 정식", "순두부 정식", "뚝배기 불고기 정식", "전복 갈비탕" };
    static int[] DishStock = { 7, 7, 7, 7 }; // stock (food remain)
    static int[] DishCost = { 8000, 9000, 10000, 12000 }; // ingredient cost
    static int[] DishPriceInt = { 17000, 18000, 19000, 25000 }; // price

    // [탄산음료, 술]
    static String[] drinkMenu = { "탄산음료", "술" };
    static int[] drinkStock = { 7, 7 }; // stock (food remain)
    static int[] drinkCost = { 1000, 2000 }; // ingredient cost
    static int[] drinkPriceInt = { 5000, 8000 }; // price

    private StockAndCost() {
    }

    public static synchronized StockAndCost getInstance() {
        if (instance == null) {
            instance = new StockAndCost();
        }
        return instance;
    }

    public int getDishStock(String menu) {
        int returnValue = 0;
        switch (menu) {
            case "황태해장국 정식":
                returnValue = DishStock[0];
                break;
            case "순두부 정식":
                returnValue = DishStock[1];
                break;
            case "뚝배기 불고기 정식":
                returnValue = DishStock[2];
                break;
            case "전복 갈비탕":
                returnValue = DishStock[3];
                break;
            default:
                System.out.println("Please type correct menu!");
                break;
        }
        return returnValue;
    }

    public int getDishCost(String menu) {
        int returnValue = 0;
        switch (menu) {
            case "황태해장국 정식":
                returnValue = DishCost[0];
                break;
            case "순두부 정식":
                returnValue = DishCost[1];
                break;
            case "뚝배기 불고기 정식":
                returnValue = DishCost[2];
                break;
            case "전복 갈비탕":
                returnValue = DishCost[3];
                break;
            default:
                System.out.println("Please type correct menu!");
                break;
        }
        return returnValue;
    }

    public int getDishPriceInt(String menu) {
        int returnValue = 0;
        switch (menu) {
            case "황태해장국 정식":
                returnValue = DishPriceInt[0];
                break;
            case "순두부 정식":
                returnValue = DishPriceInt[1];
                break;
            case "뚝배기 불고기 정식":
                returnValue = DishPriceInt[2];
                break;
            case "전복 갈비탕":
                returnValue = DishPriceInt[3];
                break;
            default:
                System.out.println("Please type correct menu!");
                break;
        }
        return returnValue;
    }

    public int getDrinkStock(String menu) {
        int returnValue = 0;
        switch (menu) {
            case "탄산음료":
                returnValue = drinkStock[0];
                break;
            case "술":
                returnValue = drinkStock[1];
                break;
            default:
                System.out.println("Please type correct menu!");
                break;
        }
        return returnValue;
    }

    public int getDrinkCost(String menu) {
        int returnValue = 0;
        switch (menu) {
            case "탄산음료":
                returnValue = drinkCost[0];
                break;
            case "술":
                returnValue = drinkCost[1];
                break;
            default:
                System.out.println("Please type correct menu!");
                break;
        }
        return returnValue;
    }

    public int getDrinkPriceInt(String menu) {
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

    public void subtractCourseStock(String menu, int number) { // 재고 감소
        if (number > 0) {
            switch (menu) {
                case "황태해장국 정식":
                    if (DishStock[0] >= number) {
                        DishStock[0] -= number;
                    } else {
                        System.out.println("Not enough stock for 황태해장국 정식");
                    }
                    break;
                case "순두부 정식":
                    if (DishStock[1] >= number) {
                        DishStock[1] -= number;
                    } else {
                        System.out.println("Not enough stock for 순두부 정식");
                    }
                    break;
                case "뚝배기 불고기 정식":
                    if (DishStock[2] >= number) {
                        DishStock[2] -= number;
                    } else {
                        System.out.println("Not enough stock for 뚝배기 불고기 정식");
                    }
                    break;
                case "전복 갈비탕":
                    if (DishStock[3] >= number) {
                        DishStock[3] -= number;
                    } else {
                        System.out.println("Not enough stock for 전복 갈비탕");
                    }
                    break;
                default:
                    System.out.println("Please type correct menu!");
                    break;
            }
        } else {
            System.out.println("Number must be positive");
        }
    }

    public void subtractDrinkStock(String menu, int number) { // 재고 감소
        if (number > 0) {
            switch (menu) {
                case "탄산음료":
                    if (drinkStock[0] >= number) {
                        drinkStock[0] -= number;
                    } else {
                        System.out.println("Not enough stock for 탄산음료");
                    }
                    break;
                case "술":
                    if (drinkStock[1] >= number) {
                        drinkStock[1] -= number;
                    } else {
                        System.out.println("Not enough stock for 술");
                    }
                    break;
                default:
                    System.out.println("Please type correct menu!");
                    break;
            }
        } else {
            System.out.println("Number must be positive");
        }
    }

}
