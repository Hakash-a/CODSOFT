import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int roundsWon = 0;
        int totalRounds = 0;
        int maxAttempts = 5;
        int score = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            int number = rand.nextInt(100) + 1; 
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("Guess a number between 1 and 100");
            System.out.println("Attempts allowed: " + maxAttempts);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");            
                if (!sc.hasNextInt()) {
                    System.out.println("❗ Please enter a valid number.");
                    sc.next(); 
                    continue;
                }
                int guess = sc.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println("❗ Guess must be between 1 and 100.");
                    continue;
                }
                attempts++;
                if (guess == number) {
                    System.out.println("✅ Correct! Attempts used: " + attempts);
                    guessedCorrectly = true;
                    roundsWon++;
                    score += (maxAttempts - attempts + 1);
                    break;
                } else if (guess > number) {
                    System.out.println("⬆ Too high!");
                } else {
                    System.out.println("⬇ Too low!");
                }
            }
            if (!guessedCorrectly) {
                System.out.println(" Attempts finished!");
                System.out.println("Correct number was: " + number);
            }
            System.out.print("Play again? (yes/no): ");
            String choice = sc.next();
            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        System.out.println("\nGame Over!");
        System.out.println("Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Final Score: " + score);
        sc.close();
    }
}