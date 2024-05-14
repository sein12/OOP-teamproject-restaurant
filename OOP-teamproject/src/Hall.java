import java.util.Random;

public class Hall {
    Random random = new Random();
    private static Hall instance;
    static Boolean[] seatList = { true }; // 공간정보를 담고 있는 리스트, 초기 좌석 상태를 의미함. true: 예약 가능, false: 예약 불가능. 현재는 좌석이 1개임.

    private Hall() {
    }

    public static synchronized Hall getInstance() {
        if (instance == null) {
            instance = new Hall();
        }
        return instance;
    }
    
    public Boolean[] getCurrentSeat() {
        return seatList; // 현재 seat 정보를 반환함
    }

    public void updateSeat(int index, Boolean isAvailable) throws IllegalArgumentException { // Spatial Data를 가지고 있는
                                                                                             // list의 정보를 updated함.
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
