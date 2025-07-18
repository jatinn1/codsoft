import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = input.nextInt();

        int totalMarks = 0;

        // Step 2: Input marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int marks = input.nextInt();

            // Validate input
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks! Enter again (0 to 100): ");
                marks = input.nextInt();
            }

            totalMarks += marks;
        }

        // Step 3: Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Step 4: Grade Calculation
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Step 5: Display results
        System.out.println("\n---- Result ----");
        System.out.println("Total Marks: " + totalMarks + "/" + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        input.close();
    }
}
