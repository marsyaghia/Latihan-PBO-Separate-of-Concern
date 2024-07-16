/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author home
 */
import java.util.Random;
import java.util.Scanner;
/**
*
* @author budi
*/
public class NumberGuessingGame extends Game {
    private int secretNumber;
    private Scanner scanner;

    public NumberGuessingGame(int guessLimit) {
        super(guessLimit);
        this.scanner = new Scanner(System.in);
    }
    private int readInt() {
        return scanner.nextInt();
    }
    
@Override
    public void play() {
        generateNumber();
        int guessesLeft = guessLimit;
        boolean numberGuessed = false;
        
        while (guessesLeft > 0 && !numberGuessed) {
            System.out.println("Sisa tebakan: " + guessesLeft);
            System.out.print("Tebakan Anda (1-100): ");
            int guess = readInt();
            
            String result = checkGuess(guess, null);
            System.out.println(result);
            
            if (result.equals("Benar!")) {
                System.out.println("Angka rahasianya adalah " + secretNumber);
                numberGuessed = true;
            } else {
                guessesLeft--;
            }
            
            if (guessesLeft == 0 && !numberGuessed) {
                System.out.println("Maaf, Anda kehabisan tebakan. Angka rahasianya adalah: " + secretNumber);
            }
        }
    }
    
@Override
    public String checkGuess(int guess, String input) {
        if (guess == secretNumber) {
            return "Benar!";
        } else if (guess < secretNumber) {
            return "Terlalu rendah";
        } else {
            return "Terlalu tinggi";
        }
    }
    public void generateNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1; // Contoh: 1-100
    }
}
