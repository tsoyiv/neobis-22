import java.util.Scanner;
public class URI1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int money = sc.nextInt();
        System.out.printf("%d%n", money);

        int hundreds = money / 100;
        money %= 100;

        int fifties = money / 50;
        money %= 50;

        int twenties = money / 20;
        money %= 20;

        int tens = money / 10;
        money %= 10;

        int fives = money / 5;
        money %= 5;

        int twos = money / 2;
        money %= 2;

        int ones = money;

        System.out.printf("%d nota(s) de R$ 100,00%n", hundreds);
        System.out.printf("%d nota(s) de R$ 50,00%n", fifties);
        System.out.printf("%d nota(s) de R$ 20,00%n", twenties);
        System.out.printf("%d nota(s) de R$ 10,00%n", tens);
        System.out.printf("%d nota(s) de R$ 5,00%n", fives);
        System.out.printf("%d nota(s) de R$ 2,00%n", twos);
        System.out.printf("%d nota(s) de R$ 1,00%n", ones);
    }
}