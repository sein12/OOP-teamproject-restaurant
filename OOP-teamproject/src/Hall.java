import java.util.Random;

public class Hall {
    private static Hall instance;
    private boolean[] seatList; // 공간정보를 담고 있는 리스트, 초기 좌석 상태를 의미함. true: 예약 가능, false: 예약 불가능. 현재는 좌석이 1개임.
    private Random random;

    // private 생성자
    private Hall() {
        seatList = new boolean[] { true }; // 초기 좌석 상태는 예약 가능(true)
        random = new Random();
    }
    
    public static synchronized Hall getInstance() {
        if (instance == null) {
            instance = new Hall();
        }
        return instance;
    }
    
    // 현재 좌석 상태 반환 메서드
    public boolean[] getCurrentSeat() {
        return seatList;
    }

    // 좌석 상태 업데이트 메서드
    public void updateSeat(int index, boolean isAvailable) {
        if (index >= 0 && index < seatList.length) {
            seatList[index] = isAvailable;
        } else {
            throw new IllegalArgumentException("Invalid seat index: " + index);
        }
    }

    public void randomizeSeats() { // 랜덤으로 정보를 업데이트함.
        for (int i = 0; i < seatList.length; i++) {
            seatList[i] = random.nextBoolean();
        }
    }
}
