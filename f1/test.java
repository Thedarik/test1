import java.util.Scanner;

public class SpeedCheckApplication {
    private static final double SPEED_LIMIT = 60.0; /*belgilangan tezlik (km/soat)*/
    private static final double DISTANCE = 100.0; /*oraqliq masofa (metrda)*/

    public static void main(String[] args) {
        boolean play = true;
        while (play) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Radar nazoratidagi hududga kirgan mashina raqamini kiriting:");
            String carNumberEnter = scanner.nextLine();
            long enterTime = System.currentTimeMillis();
            if (carNumberEnter.isBlank()) continue;
            System.out.println("Radar nazoratidagi hududdan chiqqan mashina raqamini kiriting:");
            String carNumberLeft = scanner.nextLine();
            long leftTime = System.currentTimeMillis();
            if (!carNumberEnter.equals(carNumberLeft)) {
                System.out.println("Bu raqamda mashina mavjud emas!");
                continue;
            }
            double spentTimeInSecond = (double) (leftTime - enterTime) / 1000; /*Avtomabil 100m uchun sarflagan vaqt sekundlarda*/
            double speed = calculateSpeed(spentTimeInSecond);
            if (SPEED_LIMIT < speed) {
                System.out.println(carNumberEnter + " raqamli avtomashina belgilangan tezlikdan yuqori harakatlanmoqda");
                System.out.println("Tezlik: " + speed + "km/soat");
            } else {
                System.out.println(carNumberEnter + " oq yo'l");
            }
            System.out.println("Davom ettirasizmi? (Y/N)");
            String str = scanner.nextLine();
            if (str.equalsIgnoreCase("N"))
                play = false;
        }
    }

    private static double calculateSpeed(double spentTimeInSecond) {
        return (double) (Math.round(DISTANCE / spentTimeInSecond) * 36) / 10;
    }
}
