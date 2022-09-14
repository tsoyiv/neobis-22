import java.util.Scanner;

public class URI1160 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfTests = sc.nextInt();
        for (int i = 0; i < numOfTests; i++) {
            int popOfFirstCity = sc.nextInt(); // population of the first city
            int popOfSecondCity = sc.nextInt(); // population of the second city
            double growthOfFirstCity = sc.nextDouble(); // growth of the population
            double growthOfSecondCity = sc.nextDouble();

            int years = 0;
            while (true) {
                popOfFirstCity = (int) (popOfFirstCity + (popOfFirstCity * growthOfFirstCity / 100.0));
                popOfSecondCity = (int) (popOfSecondCity + (popOfSecondCity * growthOfSecondCity / 100.0));
                years++;

                if (years > 100) {
                    System.out.println("Mais de 1 seculo.");
                    break;
                } else if (popOfFirstCity > popOfSecondCity) {
                    System.out.printf("%d anos.%n", years);
                    break;
                }
            }
        }
    }
}