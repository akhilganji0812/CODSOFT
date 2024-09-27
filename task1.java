// Header file
import java.util.Random;  // Import the Random class to generate random numbers
import java.util.Scanner; // Import the Scanner class to take input from the user

class Game {
    // Method to execute the guessing number game
    public static void Guess_number_game() {
        Random number = new Random(); // Create a Random object to generate a random number
        int count = 0; // Initialize count for the number of guesses
        int guess_number = number.nextInt(100); // Generate a random number between 0 and 100
        
        // Display initial game instructions
        System.out.println("\n**** Number Guessing Game ***\n");
        System.out.println("Hint :- Number lies between 0 to 100");
        System.out.println("Guess the number : ");
        
        // Initialize scanner to take user input
        Scanner num = new Scanner(System.in);
        int entered_number = num.nextInt(); // Capture the first guessed number from the user
        
        int score = 20; // Score deduction per wrong guess

        // Notify the user about the wrong guess
        System.out.println("You have entered wrong number");

        // Loop to continue guessing until correct number or 5 guesses exhausted
        while (guess_number != entered_number && count != 5) {
            count++; // Increment count for each wrong guess
            
            // Provide hint to the user if the guessed number is higher or lower
            if (entered_number > guess_number) {
                System.out.println("Hint :- The number is lower than what you have guessed");
            } else {
                System.out.println("Hint :- The number is higher than what you have guessed");
            }
            
            // Notify the user about the prompt for another guess
            System.out.println("Guess the number : ");
            
            // Capture the new guess from the user
            Scanner new_num = new Scanner(System.in);
            entered_number = new_num.nextInt();
        }

        // If the user exceeds 5 guesses, print failure message and zero score
        if (count == 5) {
            System.out.println("You took more chances to guess the number");
            System.out.println("Your score is " + 0);

        } else { // If guessed correctly within 5 tries, display success message
            System.out.println("You have guessed the correct number");
            System.out.println("You have taken " + count + " guesses to crack it");
            System.out.println("Your score is " + (100 - (count * score))); // Calculate final score
        }

        // Ask the user if they want to play again
        System.out.println("If you want to play again press '1' or else press '0' : ");
        Scanner num2 = new Scanner(System.in);
        int choice = num2.nextInt();

        // If user wants to play again, restart the game, otherwise exit
        if (choice == 1) {
            Guess_number_game();
        } else {
            System.out.println("Thank you for playing the game");
        }
    }

    // Main method to start the game
    public static void main(String[] args) {
        Guess_number_game(); // Initiate the guessing game
    }
}
