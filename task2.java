import java.util.Scanner;  // For Scanner Class

class Student_Grade_Calculator{
    // Global variable to store grade
    public static char grade = ' ';

    // Method to check and assign grade based on average marks
    public static void Grade_Checker(int m){
        if(m >= 90){
            grade = 'O'; // O stands for Outstanding
        }else if(m >= 80){
            grade = 'A'; // A grade
        }else if(m >= 70){
            grade = 'B'; // B grade
        }else if(m >= 60){
            grade = 'C'; // C grade
        }else if(m >= 50){
            grade = 'D'; // D grade
        }else if(m >= 40){
            grade = 'E'; // E grade (Pass)
        }else{
            grade = 'F'; // F stands for Fail
        }
    }

    // Method to calculate total marks, average, percentage and grade
    public static void Grade_Calculator(){
        System.out.println("How many subjects do you have: ");
        Scanner sub = new Scanner(System.in); // Scanner to input number of subjects
        int sub_no = sub.nextInt(); // Number of subjects
        int[] sub_marks = new int[sub_no]; // Array to store marks of each subject
        int total_marks = 0; // Variable to store total marks

        // Loop to input marks for each subject
        for(int i = 0; i < sub_no; i++){
            System.out.println("Enter marks of subject " + (i + 1) + " :");
            Scanner value = new Scanner(System.in); // Scanner to input marks for each subject
            int marks = value.nextInt(); // Marks of the current subject
            total_marks += marks; // Add marks to total
            sub_marks[i] = marks; // Store marks in array
        }

        int average_marks = (total_marks / sub_marks.length); // Calculate average marks
        double percentage_marks =  (total_marks * 100 / (sub_no * 100)); // Calculate percentage

        Grade_Checker(average_marks); // Call method to determine grade based on average marks

        // Print grade
        System.out.println(grade);

        // Display marksheet
        System.out.println(" *** Marks Sheet ***");
        for(int i = 0; i < sub_no; i++){
            System.out.println("Subject " + (i + 1) + " = " + sub_marks[i]); // Print marks for each subject
        }

        // Print total marks, average marks, percentage and grade
        System.out.println("Total marks: " + total_marks + "/" + (100 * sub_no));
        System.out.println("Average Marks Obtained: " + average_marks);
        System.out.println("Percentage Of Marks: " + percentage_marks + "%");
        System.out.println("Grade: " + grade);
    }

    // Main method to run the program
    public static void main(String[] args) {
        Grade_Calculator(); // Call method to calculate and display grades
    }
}