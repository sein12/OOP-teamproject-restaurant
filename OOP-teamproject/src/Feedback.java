import java.util.Scanner;

public class Feedback {        //  getFeedbackAndGetPayied에서 FeedbackPay
	
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String BOLD = "\u001B[1m";
    
    static int rateNum = 0;            // 평가 횟수; 평가한 사람의 수
    
    static float foodRateSum = 0;        // 음식 점수 총합
    static float serviceRateSum = 0;     // 서비스 점수 총합
    static float facilityRateSum = 0;    // 시설 점수 총합

    static float foodRateMean = 0;        // 
    static float serviceRateMean = 0;     // 
    static float facilityRateMean = 0;    // (정우) makeFeedbackSum()에서 사용할 변수 평가항목 평균값 변수

    private static Feedback instance;
    Scanner scanner;

    private Feedback() {
        scanner = new Scanner(System.in); // 생성자에서 Scanner 객체 초기화
    }

    public static Feedback getInstance() {
        if (instance == null) {
            instance = new Feedback();
        }
        return instance;
    }

    // 피드백 받는 메서드
    public void getFeedback() {
        System.out.println("고객님의 소중한 피드백을 남겨주시겠습니까? (예/아니오)를 입력하여주세요 ");
        String feedbackOk = scanner.next();
        if (feedbackOk.equals("예")) {
            rateNum++; // 피드백 남긴 사람 수
            printBanner("음식, 서비스, 시설 이 세가지 항목에 대해 고객님의 점수를 남겨주세요. \n저희 매장의 음식에 대해 1점부터 5점 사이에서 점수를 입력해주세요: ", YELLOW);
            foodRateSum += scanner.nextFloat();
            printBanner("저희 매장의 서비스에 대해 1점부터 5점 사이에서 점수를 입력해주세요: ", YELLOW);
            serviceRateSum += scanner.nextFloat();
            printBanner("저희 매장의 시설에 대해 1점부터 5점 사이에서 점수를 입력해주세요: ", YELLOW);
            facilityRateSum += scanner.nextFloat();
            scanner.nextLine(); // 개행 문자 처리 
            printBanner("고객님의 소중한 의견 감사드립니다. 남겨주신 평가는 저희 매장의 발전에 굉장히 큰 도움이 됩니다.", GREEN);
        }
    }

    public void setFeedback() { // 피드백 확인 준비하는 메소드(분야별 평균값 내는 메소드)
        if (rateNum > 0) {
            foodRateMean = foodRateSum / rateNum;
            serviceRateMean = serviceRateSum / rateNum;
            facilityRateMean = facilityRateSum / rateNum;
        } else {
            System.out.println("피드백 데이터가 없습니다.");
        }
    }
    
    private void printBanner(String message, String color) {
        System.out.println(color + BOLD + "===========================================");
        System.out.println(message);
        System.out.println("===========================================" + RESET);
    }
}
