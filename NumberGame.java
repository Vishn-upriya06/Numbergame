import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 7;
        int totalScore = 0;
        int roundsPlayed = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            roundsPlayed++;
            int attemptsUsed = 0;
            int numberToGuess = new Random().nextInt(rangeEnd - rangeStart + 1) + rangeStart;

            System.out.println("\nRound " + roundsPlayed + ":");
            System.out.println("Guess the number between " + rangeStart + " and " + rangeEnd + ".");

            boolean guessedCorrectly = false;

            while (attemptsUsed < maxAttempts) {
                System.out.print("Attempt " + (attemptsUsed + 1) + ": Enter your guess: ");

                // Handle non-integer input
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                int userGuess = scanner.nextInt();
                attemptsUsed++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number.");
                    int score = maxAttempts - attemptsUsed + 1;
                    totalScore += score;
                    System.out.println("🏆 You earned " + score + " points this round!");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("😞 You've used all attempts. The number was: " + numberToGuess);
                System.out.println("💔 No points this round.");
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        // Final results
        System.out.println("\n📊 Game Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Total score: " + totalScore);

        scanner.close();
    }
}
