import java.util.*;

class Quiz extends Thread {
    // Static arrays to hold quiz questions and answers
    public static String[] arr_que = new String[5];
    public static int[] arr_ans = new int[5];

    // 'k' indicates if time is up, 'count' tracks the number of correct answers
    public static int k = 0;
    public static int count = 0;

    // Run method for the timer thread
    public void run() {
        // Sleep for 5 seconds to simulate a timer
        try {
            Thread.sleep(5000); // Waits 5 seconds before marking time up
        } catch (InterruptedException e) {
            // If the thread is interrupted, it will skip this
        }
        // Increment 'k' to indicate that time has run out
        k += 1;
    }

    // Method to check the user's answer
    public static void check(int ans, int i) {
        // Compare user's answer with the correct answer
        if (arr_ans[i] == ans) {
            // If time has run out (k == 1), show a different message
            if (k == 1) {
                System.out.println("Correct Answer");
                System.out.println("But you ran out of time ");
                return;
            }
            System.out.println("Correct Answer");
            count++; // Increment score for correct answer
        } else {
            // If time has run out, show a different message for incorrect answers
            if (k == 1) {
                System.out.println("Incorrect");
                System.out.println("But you ran out of time ");
                return;
            }
            System.out.println("Incorrect");
        }
    }

    // Main method - where the quiz is executed
    public static void main(String[] args) {
        // Initializing quiz questions and answers
        arr_que[0] = "What is the purpose of the printf() function in C?\n" +
                     "1) To take input from the user\n" +
                     "2) To display output to the screen\n" +
                     "3) To clear the screen\n" +
                     "4) To terminate a program";
        arr_ans[0] = 2;

        arr_que[1] = "Which method is used to start a thread in Java?\n" +
                     "A) run()\n" +
                     "B) start()\n" +
                     "C) init()\n" +
                     "D) launch()";
        arr_ans[1] = 2;

        arr_que[2] = "What is the size of an int in Java?\n" +
                     "A) 8 bits\n" +
                     "B) 16 bits\n" +
                     "C) 32 bits\n" +
                     "D) 64 bits\n";
        arr_ans[2] = 3;

        arr_que[3] = "What is the output of the following Python code? print(2**3)\n" +
                     "A) 6\n" +
                     "B) 8\n" +
                     "C) 9\n" +
                     "D) 11";
        arr_ans[3] = 2;

        arr_que[4] = "What is the default value of a local variable in Java?\n" +
                     "A) 0\n" +
                     "B) null\n" +
                     "C) Depends on the type\n" +
                     "D) Local variables do not have a default value";
        arr_ans[4] = 4;

        // Start of the quiz game
        System.out.println(" *** Quiz Game *** ");
        System.out.print("Enter your name: ");
        Scanner nam = new Scanner(System.in);
        String name = nam.nextLine(); // Getting the user's name

        // Looping through all questions
        for (int i = 0; i < 5; i++) {
            Quiz t1 = new Quiz(); // Create a new thread for each question's timer
            t1.k = 0; // Reset the timer flag for each question
            System.out.println(arr_que[i]); // Display the question

            t1.start(); // Start the timer thread (5-second timer)
            Scanner val = new Scanner(System.in);
            int ans = val.nextInt(); // Capture user's answer

            check(ans, i); // Check the user's answer

            // Wait for the timer thread to finish
            try {
                t1.join(); // Ensure timer finishes before moving to the next question
            } catch (InterruptedException e) {
                e.printStackTrace(); // Print any interruption errors
            }

            System.out.println("Moving to next question");
        }

        // Display the final score card
        System.out.println("\n Score Card ");
        System.out.println("Name: " + name);
        System.out.println("Score: " + count);
        System.out.println("Thank you for participating in the quiz! We hope to see you again soon");
    }
}
