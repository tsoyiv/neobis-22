import java.util.Scanner;

public class URI1079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numbOfTests = sc.nextInt();

        for (int i = 0; i < numbOfTests; i++) {

            double firstNumb = sc.nextDouble();
            double secondNumb = sc.nextDouble();
            double thirdNumb = sc.nextDouble();

            double  average = ((firstNumb * 2) + (secondNumb * 3) + (thirdNumb * 5)) / 10;

            System.out.printf("%.1f%n", average);
        }
    }
}