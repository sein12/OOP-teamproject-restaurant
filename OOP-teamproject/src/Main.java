public class Main {
    public static Table table1 = new Table();
    public static PreOpen pre = new PreOpen();
    public static DuringOpen duringOpen = new DuringOpen();
    public static AfterOpen afterOpen = new AfterOpen();

    public static void main(String[] args) {
        System.out.println("레스토랑 프로젝트");
        System.out.println("------------");
        System.out.println("이재윤, 이정우, 장예은, 최세인");
        System.out.println("비우고 채우고 나누다. 비채나에 오신 것을 환영합니다.");
        System.out.println("현재는 가게 오픈 전, 준비 시간");

        pre.chooseJob();

        if (pre.openStore) {
            duringOpen.openRestaurant();
        }
        
        afterOpen.closeOperations();
    }
}
