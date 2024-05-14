import java.util.Random;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEW;
public class ReservationSystem{
public static synchronized ReservationSystem getInstance() {
        if (instance == null) {
            instance = new ReservationSystem();
        }
        return instance;
    }
    public static boolean[] reservationtime = new boolean[7];//db에서 자체 진행할건지
    public void selectReservationTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("예약할 시간대를 선택해주세요 (12시부터 18시까지): ");
        int selectedTime = scanner.nextInt();
        if (selectedTime >= 12 && selectedTime <= 18) {
            reservationtime[selectedTime - 12] = true;
            System.out.println(selectedTime + "시에 예약되었습니다.");
            Hall.getInstance().updateSeat(0, selectedTime);
        } else {
            System.out.println("잘못된 시간대입니다. 12시부터 18시까지 선택해주세요.");
        }
    }

    public void Call_resevation() {
        for (int i = 0; i < reservationtime.length; i++) {
            if (reservationtime[i]=true) {
                System.out.println("오늘 "+reservationtime[i]+"시에 예약이 준비되어 있습니다.");}
            }
    }
}
