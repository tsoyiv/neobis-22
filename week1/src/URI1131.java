import java.util.Scanner;

public class URI1131 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int goalsOfInter;
        int goalsOfGremio;
        int repeatedInput;
        int numbOfMatches = 0;
        int counterForInter = 0;
        int counterForGremio = 0;
        int numbOfDraws = 0;

        do {
            numbOfMatches++;
            goalsOfInter = sc.nextInt();
            goalsOfGremio = sc.nextInt();
            repeatedInput = sc.nextInt();

            if (goalsOfInter > goalsOfGremio) {
                counterForInter++;
            } else if (goalsOfInter < goalsOfGremio) {
                counterForGremio++;
            } else {
                numbOfDraws++;
            }

        } while (repeatedInput != 2);

        for (int i = 0; i < numbOfMatches; i++) {
            System.out.println("Novo grenal (1-sim 2-nao)");

        }
        System.out.println(numbOfMatches + " grenais");
        System.out.println("Inter:" + counterForInter);
        System.out.println("Gremio:" + counterForGremio);
        System.out.println("Empates:" + numbOfDraws);

        if (counterForInter > counterForGremio) {
            System.out.println("Inter venceu mais");
        } else if (counterForInter < counterForGremio) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Nao houve vencedor");
        }
    }
}
