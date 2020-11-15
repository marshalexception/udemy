import java.util.Scanner;

public class UserInput {

    public static void main (String args[]) {

        Scanner scanner = new Scanner(System.in);
        int x;

        System.out.println("Enter value of x: ");
        x = scanner.nextInt();
        // for strings: .next();

        System.out.println("User entered value " + x + " for x");
    }
}
