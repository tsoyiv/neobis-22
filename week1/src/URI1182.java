import java.util.Scanner;

public class URI1182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int chosenColumn = sc.nextInt();

        double[][] arr = new double[12][12];
        double sumOfNums = 0;

        char s = sc.next().charAt(0);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }

        for (double[] doubles : arr) {
            sumOfNums += doubles[chosenColumn];
        }

        if (s == 'S') {
            System.out.printf("%.1f%n", sumOfNums);
        } else {
            System.out.printf("%.1f%n", (sumOfNums / arr.length));
        }
    }
}
