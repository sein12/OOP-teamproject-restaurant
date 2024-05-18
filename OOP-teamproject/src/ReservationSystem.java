import java.util.Random;
import java.util.Scanner;

public class ReservationSystem{
    private static ReservationSystem instance; // 싱글톤 인스턴스
    private static final boolean[] reservationTime = new boolean[7]; // 예약 시간 배열
    
    private ReservationSystem() { // private 생성자
    }

    public static synchronized ReservationSystem getInstance() {
        if (instance == null) {
            instance = new ReservationSystem();
        }
        return instance;
    }

    public void selectReservationTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("예약할 시간대를 선택해주세요 (12시부터 18시까지): ");
        int selectedTime = scanner.nextInt();
        if (selectedTime >= 12 && selectedTime <= 18) {
            reservationTime[selectedTime - 12] = true;
            System.out.println(selectedTime + "시에 예약되었습니다.");
            Hall.getInstance().updateSeat(0, true); // 좌석 상태를 예약된 것으로 업데이트
        } else {
            System.out.println("잘못된 시간대입니다. 12시부터 18시까지 선택해주세요.");
        }
    }

    public void callReservation() {
        for (int i = 0; i < reservationTime.length; i++) {
            if (reservationTime[i]) {
                System.out.println("오늘 " + (i + 12) + "시에 예약이 준비되어 있습니다.");
            }
        }
    }
}
