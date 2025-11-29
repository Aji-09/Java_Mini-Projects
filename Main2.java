import java.util.Scanner;

public class Main2 {

    // Method to compute average
    public static double getAverage(int total, int count) {
        return (double) total / count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String studentName;
        int quizTotal = 0;
        double average;

        System.out.print("Enter student name: ");
        studentName = input.next();

        // Get 3 quiz scores
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter quiz score " + i + ": ");
            int score = input.nextInt();

            // Validate score (must be 0–100)
            while (score < 0 || score > 100) {
                System.out.println("Invalid! Score must be between 0 and 100.");
                System.out.print("Enter quiz score " + i + ": ");
                score = input.nextInt();
            }

            quizTotal += score;
        }

        // Compute average
        average = getAverage(quizTotal, 3);

        // Output result
        System.out.println("\n--- RESULT ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Average Score: " + String.format("%.2f", average));

        if (average >= 75) {
            System.out.println("Remark: PASSED");
        } else {
            System.out.println("Remark: FAILED");
        }
    }
}
