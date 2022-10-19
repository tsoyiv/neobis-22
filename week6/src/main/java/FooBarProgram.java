import java.util.Scanner;

public class FooBarProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        System.out.println(foobar(input) + " " + input);
    }

    private static String foobar(int input) {

        String word = " ";

        if(input % 2 == 0) {
            word = "foo";
        } else {
            word = "bar";
        }
        return word;
    }
}
