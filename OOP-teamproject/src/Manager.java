import java.util.Scanner;

public class Manager extends Server{        // Manager class는 Server class를 상속 받음.
	static Feedback feedback = Feedback.getInstance();   // manageFeedback() 사용; feedbackGetAndCheck에서 Feedback으로 변경
	
	public void feedbackMent(String category, float point, String who) { // food와 service에 관해서는 같은 메소드 사용
        if (point >= 3.7) {
            System.out.println(category + "에 관한 평가 점수가 " + point + "점으로 매우 좋습니다. 모두 " + who + "님들께 박수 부탁드립니다.");
        } else if (point >= 2.5) {
            System.out.println(category + "에 관한 평가 점수가 " + point + "점으로 나쁘지는 않습니다만, " + who + "님들 조금 더 분발하셔야 할 것 같습니다.");
        } else {
            System.out.println(category + "에 관한 평가 점수가 " + point + "점으로 나쁘네요. " + who + "님들과는 차후에 면담을 갖도록 하겠습니다.");
        }
    }
	
	public void feedbackMent(String category, float point) { // facility에 관해서는 다른 메소드 사용 (overload)
        if (point >= 3.5) {
            System.out.println(category + "에 관한 평가 점수가 " + point + "점으로 매우 좋습니다. 모두 서로에게 박수 부탁드립니다.");
        } else if (point >= 1.7) {
            System.out.println(category + "에 관한 평가 점수가 " + point + "점으로 나쁘지는 않습니다만, 서버님들과 쉐프님들께서는 시설의 청결도에 조금 더 신경 써주시고 저는 새로운 인테리어를 준비하도록 하겠습니다.");
        } else {
            System.out.println(category + "에 관한 평가 점수가 " + point + "점으로 나쁘네요. 위생과 관련하여 서버님들과 쉐프님들에게 재교육이 있을 예정이고 업체를 불러 대청소를 진행할 것이며, 조만간 인테리어 공사와 시설보수가 있을 예정입니다.");
        }
    }

	public void manageFeedback() { // 매니저가 feedback을 확인해서 브리핑하는 메소드
        System.out.println("오늘의 피드백을 확인하겠습니다. 직원 여러분 모두 착석 부탁드립니다."); // 직원들 있는데서 feedback 읽고 브리핑하는 것
        feedback.setFeedback(); // 피드백 평균값을 계산
        feedbackMent("음식", Feedback.foodRateMean, "쉐프"); // 음식의 feedback 점수에 관한 평가
        feedbackMent("서비스", Feedback.serviceRateMean, "서버"); // 서비스의 feedback 점수에 관한 평가
        feedbackMent("시설", Feedback.facilityRateMean); // 시설의 feedback 점수에 관한 평가
    }

	public void openRestaurant() { // 매니저 영업을 시작 메소드
        System.out.println("현 시간부로 저희 매장의 영업을 시작하겠습니다. 12시 타임 손님께서는 지금부터 입장이 가능하십니다.");
    }

    public void closeRestaurant() { // 매니저 라스트 오더 마감 메소드
        System.out.println("현 시간부로 금일 저희 매장의 라스트 오더가 마감되었습니다. 손님 입장 및 기존 손님에 대해 추가 주문을 받지 않습니다. 감사합니다.");
    }

    public void SalesReport() {
        System.out.println("오늘의 매출은 " + Sales.Sales + "원 입니다.");
    }
}
