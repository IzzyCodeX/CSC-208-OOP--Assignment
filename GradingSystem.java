/*
Name: Adelusi Oluwanifemi Israel
Matric No: CSC/25/6879
Department: Computer Science
Course Code: CSC 208
Course Title: Object Oriented Programming

Assignment:
Build a working functional grading system
that can accommodate at least 5 students.
*/

import java.util.Scanner;

public class GradingSystem {

    // Method to convert score into grade
    public static String getGrade(int score) {
        if (score >= 70) {
            return "A";
        } else if (score >= 60) {
            return "B";
        } else if (score >= 50) {
            return "C";
        } else if (score >= 45) {
            return "D";
        } else if (score >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    // Method to convert grade into grade points
    public static int getPoint(String grade) {
        if (grade.equals("A")) {
            return 5;
        } else if (grade.equals("B")) {
            return 4;
        } else if (grade.equals("C")) {
            return 3;
        } else if (grade.equals("D")) {
            return 2;
        } else if (grade.equals("E")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Variable to store number of students
        int numStudents;

        // Ensure the system accepts at least 5 students
        do {
            System.out.print("Enter number of students: ");
            numStudents = input.nextInt();

            if (numStudents < 5) {
                System.out.println("Error! Number of students cannot be less than 5.");
            }

        } while (numStudents < 5);

        // Arrays to store student names and GPAs
        String[] names = new String[numStudents];
        double[] gpas = new double[numStudents];

        // Fixed number of courses for each student
        int numCourses = 5;

        // Clear input buffer
        input.nextLine();

        // Outer loop for students
        for (int i = 0; i < numStudents; i++) {

            System.out.println("\nEnter details for Student " + (i + 1));

            // Input student name
            System.out.print("Enter student name: ");
            names[i] = input.nextLine();

            // Variable to store total grade points
            int totalPoints = 0;

            // Inner loop for courses
            for (int j = 0; j < numCourses; j++) {

                int score;

                // Validate score input
                do {
                    System.out.print("Enter score for Course " + (j + 1) + ": ");
                    score = input.nextInt();

                    if (score < 0 || score > 100) {
                        System.out.println("Invalid score! Enter a score between 0 and 100.");
                    }

                } while (score < 0 || score > 100);

                // Convert score to grade
                String grade = getGrade(score);

                // Convert grade to grade point
                int point = getPoint(grade);

                // Add grade point to total points
                totalPoints += point;

                // Display grade and point
                System.out.println("Grade: " + grade + " | Point: " + point);

                // Calculate and display cumulative GPA for the student so far
                double cumulativeStudentGPA = (double) totalPoints / (j + 1);
                System.out.println("Cumulative GPA so far: " + cumulativeStudentGPA);
            }

            // Calculate GPA for the student
            gpas[i] = (double) totalPoints / numCourses;

            // Display student GPA
            System.out.println("Student Name: " + names[i]);
            System.out.println("GPA: " + gpas[i]);

            // Clear input buffer for next student
            input.nextLine();
        }

        // Display summary of all students
        System.out.println("\n===== STUDENTS GPA SUMMARY =====");

        for (int i = 0; i < numStudents; i++) {
            System.out.println(names[i] + " - GPA: " + gpas[i]);
        }

        // Close scanner
        input.close();
    }
}