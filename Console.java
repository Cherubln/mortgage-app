import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value > min && value <= max)
                break;
            System.out.println("Enter value between " + min + " and " + max);
        }
        return value;
    }

    // Method overloading
    public static double readNumber(String prompt) {
        System.out.println(prompt + ": ");
        double value = scanner.nextDouble();
        return value;
    }
}
