package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NumbersFile {

    private final File file;

    public NumbersFile(String path) throws IOException {
        file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public List<Integer> read(int limit) throws IOException {
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            integers.addAll(getNumbersFromLine(scanner.nextLine()));
        }
        scanner.close();
        if (limit <= 0) {
            return integers;
        } else {
            return integers.stream().filter(num -> num <= limit).toList();
        }
    }

    public void write(Integer... writable) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (Integer number : writable) {
            fileWriter.write(number + " ");
        }
        fileWriter.close();
    }



    private List<Integer> getNumbersFromLine(String line) {
        return Arrays.stream(line.split(" ")).map(Integer::valueOf).toList();
    }
}