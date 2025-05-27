import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        System.out.println("Welcome to the Student Grade Tracker.");
        System.out.println("Enter student grades between 0 and 100.");
        System.out.println("Type 'done' to finish input and see the results.\n");

        while (true) {
            System.out.print("Enter grade (or 'done' to finish): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int grade = Integer.parseInt(input);
                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade. Please enter a number between 0 and 100.");
                    continue;
                }
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer grade or 'done'.");
            }
        }

        if (grades.isEmpty()) {
            System.out.println("\nNo grades were entered.");
        } else {
            int sum = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int grade : grades) {
                sum += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = (double) sum / grades.size();

            System.out.println("\nGrade Summary:");
            System.out.printf("Number of grades entered: %d%n", grades.size());
            System.out.printf("Average grade: %.2f%n", average);
            System.out.printf("Highest grade: %d%n", highest);
            System.out.printf("Lowest grade: %d%n", lowest);
        }

        scanner.close();
        System.out.println("\nThank you for using Student Grade Tracker!");
    }
}
