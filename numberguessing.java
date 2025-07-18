import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 7;
        int score = 0;
        int round = 0;
        String playAgain;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            round++;

            System.out.println("\n🔁 Round " + round + " begins!");
            System.out.println("Guess the number between " + min + " and " + max + ".");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");
                int userGuess;

                // Input validation
                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("❌ Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("⬆️ Too low!");
                } else {
                    System.out.println("⬇️ Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all your attempts! The number was: " + targetNumber);
            }

            System.out.println("⭐ Score: " + score + " | Rounds Played: " + round);
            System.out.print("🔄 Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().trim().toLowerCase();

        } while (playAgain.equals("yes"));

        System.out.println("\n🏁 Game Over! You won " + score + " out of " + round + " rounds.");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
