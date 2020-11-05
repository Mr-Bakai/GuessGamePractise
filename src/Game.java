import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    HidenNumbers hdn = new HidenNumbers();
    int numberOfHits = 0;
    int numberOfGuesses = 0;
    boolean isAlive = true;
    String input;
    String result;


    public void startGame() {
        createRandomNumbers();

        while (isAlive) {
            System.out.println(Arrays.toString(hdn.getHiddenNumbers()));
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter your number and i will check, it may take some time");
            input = sc.next();


            checkMatches(input);
            if(result.equals("miss")){
                System.out.println("\ndude you have missed try one more time");
            }
        }
    }
    private String checkMatches(String input){
        numberOfGuesses++;
        result = "miss";

        int guess = Integer.parseInt(input);

        for (int temp : hdn.getHiddenNumbers()){
            if (temp == guess){
                numberOfHits++;
                if (numberOfHits == 3) {
                    result = "kill";
                    System.out.println("Whoaahhhh you killed it");
                    System.out.println("You have tried " + numberOfGuesses + " Times");
                    isAlive = false;
                    break;
                }
                if (temp == guess) { // does not enter here while (4 == 5 )
                    result = "hit";
                    System.out.println("Good job you hit it!!!!");
                } else {
                    result = "miss";
                }
            }
        }
        return result;
    }

    private void createRandomNumbers() {
        Random r = new Random();
        int randoms = r.nextInt(11);

        int[] temps = {randoms,
                       randoms + 1,
                       randoms + 2};
        hdn.setHiddenNumbers(temps);
        System.out.println("I have created random numbers and  gave them location, " +
                "           \nYour task is to hit hidden numbers in fewest number of guesses " +
                "           \nDude good luck rock it 👌");
    }
}
