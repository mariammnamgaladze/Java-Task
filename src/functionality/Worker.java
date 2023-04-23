package functionality;

import data.NumbersFile;
import exeption.InvalidNumberException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Worker {

    private Worker() {
    }


    public static int getSumOfNumbers(List<Integer> numberList) {
        int sum = 0;
        for (Integer number : numberList) {
            sum += number;
        }
        return sum;
    }

    public static List<Integer> generateFromRange(int range) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static List<Integer> getNumbers(
            NumbersFile numbersFile,
            int limit
    ) throws IOException, InvalidNumberException {
        var numbers = numbersFile.read(limit);
        for (Integer number : numbers) {
            if (number < 0) throw new InvalidNumberException();
        }
        return numbers;
    }
}