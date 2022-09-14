import java.util.Scanner;

public class URI1045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double firstNum = sc.nextDouble();
        double secondNum = sc.nextDouble();
        double thirdNum = sc.nextDouble();
        double temp;

        if (firstNum < secondNum) {
            temp = firstNum;
            firstNum = secondNum;
            secondNum = temp;
        }
        if (firstNum < thirdNum) {
            temp = firstNum;
            firstNum = thirdNum;
            thirdNum = temp;
        }

        double repeatedComputation = Math.pow(secondNum, 2) + Math.pow(thirdNum, 2);

        if (firstNum >= secondNum + thirdNum) {
            System.out.println("NAO FORMA TRIANGULO");
        } else if (Math.pow(firstNum, 2) > repeatedComputation) {
            System.out.println("TRIANGULO OBTUSANGULO");
        }
        if (Math.pow(firstNum, 2) == repeatedComputation) {
            System.out.println("TRIANGULO RETANGULO");
        }
        if (Math.pow(firstNum, 2) < repeatedComputation) {
            System.out.println("TRIANGULO ACUTANGULO");
        }
        if (firstNum == secondNum && firstNum == thirdNum && secondNum == thirdNum) {
            System.out.println("TRIANGULO EQUILATERO");
        }
        if ((firstNum == secondNum) && (firstNum != thirdNum) || (firstNum == thirdNum) && (firstNum != secondNum)
                || (secondNum == thirdNum) && (secondNum != firstNum)) {
            System.out.println("TRIANGULO ISOSCELES");
        }
    }
}
