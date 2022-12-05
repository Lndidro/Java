package by.gsu.pms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderFromFile {
    public static List<Car> readData() {
        List<String> lines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader("src/In.txt"))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException exception) {
            System.out.println("There is not such file");
            exception.printStackTrace();
        }
        for (String line: lines) {
            String[] splittedLine = line.split(" ");
            if (splittedLine.length != 7) {
                System.out.print("Incorrect line. Skipped.");
                break;
            }
            Car car = new Car(splittedLine);
            cars.add(car);
        }

        return cars;
    }
}
