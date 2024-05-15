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

    public void subtractCourseStock(String menu, int number) {// 재고 감소
        if (number > 0) {
            switch (menu) {
                case "황태해장국 정식":
                    if (courseStock[0] >= number) {
                        courseStock[0] -= number;
                    } else {
                        System.out.println("Not enough stock for 황태해장국 정식");
                    }
                    break;
                case "순두부 정식":
                    if (courseStock[1] >= number) {
                        courseStock[1] -= number;
                    } else {
                        System.out.println("Not enough stock for 순두부 정식");
                    }
                    break;
                case "뚝배기 불고기 정식":
                    if (courseStock[2] >= number) {
                        courseStock[2] -= number;
                    } else {
                        System.out.println("Not enough stock for 뚝배기 불고기 정식");
                    }
                    break;
                case "전복 갈비탕":
                    if (courseStock[3] >= number) {
                        courseStock[3] -= number;
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

// Doesn't use now

// -----------------

/**
 * public void setCourseStock(String menu, int number) { // number로 직접 재고 설정 메뉴와
 * 수량 입력
 * if (number > 0) {
 * switch (menu) {
 * case "황태해장국 정식":
 * courseStock[0] = number;
 * break;
 * case "순두부 정식":
 * courseStock[1] = number;
 * break;
 * case "뚝배기 불고기 정식":
 * courseStock[2] = number;
 * break;
 * case "전복 갈비탕":
 * courseStock[3] = number;
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * } else {
 * System.out.println("Number must be positive or zero");
 * }
 * }
 * 
 * public void addCourseStock(String menu, int number) { // 재고 추가
 * if (number > 0) {
 * switch (menu) {
 * case "황태해장국 정식":
 * courseStock[0] += number;
 * break;
 * case "순두부 정식":
 * courseStock[1] += number;
 * break;
 * case "뚝배기 불고기 정식":
 * courseStock[2] += number;
 * break;
 * case "전복 갈비탕":
 * courseStock[3] += number;
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * } else {
 * System.out.println("Number must be positive or zero");
 * }
 * }
 * 
 * public void subtractCourseStock(String menu, int number) {// 재고 감소
 * if (number > 0) {
 * switch (menu) {
 * case "황태해장국 정식":
 * if (courseStock[0] >= number) {
 * courseStock[0] -= number;
 * } else {
 * System.out.println("Not enough stock for 황태해장국 정식");
 * }
 * break;
 * case "순두부 정식":
 * if (courseStock[1] >= number) {
 * courseStock[1] -= number;
 * } else {
 * System.out.println("Not enough stock for 순두부 정식");
 * }
 * break;
 * case "뚝배기 불고기 정식":
 * if (courseStock[2] >= number) {
 * courseStock[2] -= number;
 * } else {
 * System.out.println("Not enough stock for 뚝배기 불고기 정식");
 * }
 * break;
 * case "전복 갈비탕":
 * if (courseStock[3] >= number) {
 * courseStock[3] -= number;
 * } else {
 * System.out.println("Not enough stock for 전복 갈비탕");
 * }
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * } else {
 * System.out.println("Number must be positive");
 * }
 * }
 * 
 * public int getCourseCost(String menu) {
 * int returnValue = 0;
 * switch (menu) {
 * case "황태해장국 정식":
 * returnValue = courseCost[0];
 * break;
 * case "순두부 정식":
 * returnValue = courseCost[1];
 * break;
 * case "뚝배기 불고기 정식":
 * returnValue = courseCost[2];
 * break;
 * case "전복 갈비탕":
 * returnValue = courseCost[3];
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * return returnValue;
 * }
 * 
 * public int[] getDrinkStock() {
 * return drinkStock;
 * }
 * 
 * public int getDrinkStock(String menu) {
 * int returnValue = 0;
 * switch (menu) {
 * case "탄산음료":
 * returnValue = drinkStock[0];
 * break;
 * case "술":
 * returnValue = drinkStock[1];
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * return returnValue;
 * }
 * 
 * public void setDrinkStock(String menu, int number) {
 * if (number > 0) {
 * switch (menu) {
 * case "탄산음료":
 * drinkStock[0] = number;
 * break;
 * case "술":
 * drinkStock[1] = number;
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * } else {
 * System.out.println("Number must be positive or zero");
 * }
 * }
 * 
 * public void addDrinkStock(String menu, int number) { // 재고 추가
 * if (number > 0) { // 여기서는 0도 유효한 값으로 처리합니다.
 * switch (menu) {
 * case "탄산음료":
 * drinkStock[0] += number;
 * break;
 * case "술":
 * drinkStock[1] += number;
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * } else
 * 
 * {
 * System.out.println("Number must be positive or zero");
 * }
 * }
 * 
 * public void subtractDrinkStock(String menu, int number) { // 재고 감소
 * if (number > 0) {
 * switch (menu) {
 * case "탄산음료":
 * if (drinkStock[0] >= number) {
 * drinkStock[0] -= number;
 * } else {
 * System.out.println("Not enough stock for 탄산음료");
 * }
 * break;
 * case "술":
 * if (drinkStock[1] >= number) {
 * drinkStock[1] -= number;
 * } else {
 * System.out.println("Not enough stock for 술");
 * }
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * } else {
 * System.out.println("Number must be positive");
 * }
 * }
 * 
 * public int getDrinkCost(String menu) {
 * int returnValue = 0;
 * switch (menu) {
 * case "탄산음료":
 * returnValue = drinkCost[0];
 * break;
 * case "술":
 * returnValue = drinkCost[1];
 * break;
 * default:
 * System.out.println("Please type correct menu!");
 * break;
 * }
 * return returnValue;
 * }
 **/