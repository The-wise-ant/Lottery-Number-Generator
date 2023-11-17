import java.util.Arrays;
import java.util.Random;

/**
 * The Main class generates a lottery draw with a specified number of slots.
 * It ensures that the drawn numbers are unique and sorts them in ascending order.
 */
public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        int min = 1, max = 49, slots = 6;

        // Initialize an array to store lottery numbers; all elements are initially set to zero.
        int[] lotteryArray = new int[slots];

        boolean isRepeated;
        int randomNumber = 0;

        for (int indexDrawn = 0; indexDrawn < slots; indexDrawn++) {

            do {
                isRepeated = false;
                randomNumber = rand.nextInt(max + 1 - min) + min;

                // Check if the randomly generated number has been drawn before.
                for (int k = 0; k <= indexDrawn; k++) {
                    if (lotteryArray[k] == randomNumber) {
                        isRepeated = true;
                        break;
                    }
                }

            } while (isRepeated);

            lotteryArray[indexDrawn] = randomNumber;
        }

        // Sort the array in ascending order.
        Arrays.sort(lotteryArray);
        System.out.println("The result of the lottery:");

        for (int i = 0; i < slots; i++) {
            System.out.print(lotteryArray[i] + " ");
        }
    }
}
