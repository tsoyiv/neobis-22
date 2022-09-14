import java.util.Scanner;

public class URI1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int initialHour = sc.nextInt();
        int initialMinute = sc.nextInt();
        int finalHour = sc.nextInt();
        int finalMinute = sc.nextInt();

        int startInMin = initialHour * 60 + initialMinute;
        int endInMin = finalHour * 60 + finalMinute;

        int duration = (24 * 60 - startInMin) + endInMin;

        int durationForHour = duration / 60;
        int durationForMinute = duration % 60;

        if (durationForHour >= 24 && durationForMinute >= 1) {
            durationForHour %= 24;
        }
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", durationForHour, durationForMinute);

    }
}
