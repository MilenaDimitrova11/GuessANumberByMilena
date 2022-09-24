import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random randomNumber = new Random();
        int computerNumber = 1 + randomNumber.nextInt(99);

        System.out.printf("Welcome and let's play! :)%nYou have 7 tries to guess the number.");
        int counter = 1;
        boolean isGuessed = false;


        while (counter <= 7) {
            System.out.print("Guess a number (1-100): ");
            String input = scanner.next();
            int playerNumber;
            boolean isValid = true;


            for (int i = 0; i <= input.length() - 1; i++) {
                if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                playerNumber = Integer.parseInt(input);
                if (playerNumber == computerNumber) {
                    System.out.println("You guessed it!");
                    System.out.println("Good job!");
                    isGuessed = true;
                    break;
                } else if (playerNumber > computerNumber) {
                    if (counter == 7) {
                        break;
                    }

                    System.out.printf("Too High. You have %d tries more.", (7 - counter));
                    counter++;
                } else {
                    if (counter == 7) {
                        break;
                    }
                    System.out.printf("Too Low. You have %d tries more.", (7 - counter));
                    counter++;
                }
            } else {
                System.out.println("Invalid input.");
            }


        }
        if (!isGuessed) {
            System.out.println("You don't have more tries. You can start a new game and try again! ");
        }


    }
}
