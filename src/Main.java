
import data.NumbersFile;
import exeption.InvalidNumberException;
import functionality.Worker;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            NumbersFile provider = new NumbersFile("namgala");

            Integer[] numbers = Worker.generateFromRange(24).toArray(Integer[]::new);
            provider.write(numbers);

            try {
                Worker.getNumbers(provider, 10).forEach(System.out::print);
                System.out.println("\n");
            } catch (InvalidNumberException | NumberFormatException e) {
                e.printStackTrace();
            }

            try {
                int sum = Worker.getSumOfNumbers(provider.read(0));
                System.out.println(sum);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}