import java.util.Scanner;

public class URI1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double banknotesAndCoins = sc.nextDouble();

        System.out.println("NOTAS:");

        int hundreds = (int) (banknotesAndCoins / 100);
        banknotesAndCoins %= 100;
        System.out.printf("%d nota(s) de R$ 100.00%n", hundreds);

        int fifties = (int) (banknotesAndCoins / 50);
        banknotesAndCoins %= 50;
        System.out.printf("%d nota(s) de R$ 50.00%n", fifties);

        int twenties = (int) (banknotesAndCoins / 20);
        banknotesAndCoins %= 20;
        System.out.printf("%d nota(s) de R$ 20.00%n", twenties);


        int tens = (int) banknotesAndCoins / 10;
        banknotesAndCoins %= 10;
        System.out.printf("%d nota(s) de R$ 10.00%n", tens);


        int fives = (int) banknotesAndCoins / 5;
        banknotesAndCoins %= 5;
        System.out.printf("%d nota(s) de R$ 5.00%n", fives);


        int twos = (int) banknotesAndCoins / 2;
        banknotesAndCoins %= 2;
        System.out.printf("%d nota(s) de R$ 2.00%n", twos);
        banknotesAndCoins *= 100;

        System.out.println("MOEDAS:");

        int a = (int) (banknotesAndCoins / 100);
        banknotesAndCoins %= 100;
        System.out.printf("%d moeda(s) de R$ 1.00%n", a);

        int b = (int) (banknotesAndCoins / 50);
        banknotesAndCoins %= 50;
        System.out.printf("%d moeda(s) de R$ 0.50%n", b);

        int c = (int) (banknotesAndCoins / 25);
        banknotesAndCoins %= 25;
        System.out.printf("%d moeda(s) de R$ 0.25%n", c);

        int d = (int) (banknotesAndCoins / 10);
        banknotesAndCoins %= 10;
        System.out.printf("%d moeda(s) de R$ 0.10%n", d);

        int e = (int) (banknotesAndCoins / 5);
        banknotesAndCoins %= 5;
        System.out.printf("%d moeda(s) de R$ 0.05%n", e);

        int f = (int) banknotesAndCoins;
        System.out.printf("%d moeda(s) de R$ 0.01%n", f);
    }
}