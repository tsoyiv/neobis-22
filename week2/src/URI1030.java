import java.util.ArrayList;
import java.util.Scanner;

public class URI1030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numbOfTests = sc.nextInt();
        int numbOfPeople;
        int numbOfTurns;

        for (int i = 1; i <= numbOfTests; i++) {
            numbOfPeople = sc.nextInt();
            numbOfTurns = sc.nextInt();

            System.out.printf("Case %d: %d%n", i, removeNumbers(numbOfPeople, numbOfTurns));
        }

    }

    private static int removeNumbers(int numbOfPeople, int numbOfTurns) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < numbOfPeople; j++) {
            list.add(j + 1);
        }
        int j = -1;
        while (list.size() > 1) {
            j = (j + numbOfTurns) % numbOfPeople;
            list.remove(j);
            numbOfPeople--;
            j--;
        }

        return list.get(0);
    }
}

