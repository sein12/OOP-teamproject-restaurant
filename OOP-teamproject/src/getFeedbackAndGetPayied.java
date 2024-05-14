import java.util.Scanner;

public class getFeedbackAndGetPayied {
    static int rateNum = 0;            // 평가 횟수; 평가한 사람의 수
    static float foodRateSum = 0;        // 음식 점수 총합
    static float serviceRateSum = 0;     // 서비스 점수 총합
    static float facilityRateSum = 0;    // 시설 점수 총합

    private static getFeedbackAndGetPayied instance;

    private getFeedbackAndGetPayied() {
    }

    public static getFeedbackAndGetPayied getInstance() {
        if (instance == null) {
            instance = new getFeedbackAndGetPayied();
        }
        return instance;
    }

    // 피드백과 별점을 받아 처리하는 메서드
    public void getFeedback() {
        System.out.println("고객님의 소중한 피드백을 남겨주시겠습니까? (예/아니오)를 입력하여주세요 ");
        Scanner scanner = new Scanner(System.in);
        String feedbackok = scanner.next();
        if (feedbackok.equals("예")) {
            System.out.println("음식, 서비스, 시설 이 세가지 항목에 대해 고객님의 점수를 남겨주세요.");
            System.out.println("저희 매장의 음식에 대해 1점부터 5점 사이에서 점수를 입력해주세요: ");
            foodRateSum += scanner.nextFloat();
            System.out.println("저희 매장의 서비스에 대해 1점부터 5점 사이에서 점수를 입력해주세요: ");
            serviceRateSum += scanner.nextFloat();
            System.out.println("저희 매장의 시설에 대해 1점부터 5점 사이에서 점수를 입력해주세요: ");
            facilityRateSum += scanner.nextFloat();
            System.out.println("저희 매장에 대해 자유로운 의견 남겨주세요 : ");
            freefeedback += scanner.next();
            System.out.println("고객님의 소중한 의견 감사드립니다. 남겨주신 평가는 저희 매장의 발전에 굉장히 큰 도움이 됩니다.");
            rateNum++;
        }
    }
    public void todaysreview() {
        return freefeedback;
    }
    public double getFoodRate() {
        if (rateNum == 0) {
            return 0;
        }
        return foodRateSum / rateNum;
    }

    public double getServiceRate() {
        if (rateNum == 0) {
            return 0;
        }
        return serviceRateSum / rateNum;
    }

    public double getFacilityRate(){
        if (rateNum == 0) {
            return 0;
        }
        return facilityRateSum / rateNum;
    }
}
