package by.gsu.pms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterToFile {
    public static void writeToFile(List<Car> cars) {
        File file = new File("src/Out.txt");
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
        for (var car: cars) {
            try (FileWriter writer = new FileWriter("src/Out.txt", true)) {
                String string = car.toString().replaceAll("[\\'|\\{|\\}|\\,]", "");
                String[] line = string.split(" ");
                string = "";
                for (int i = 0; i < line.length; i++) {
                    string += line[i].replaceAll("^\\w*=", "") + " ";
                }
                writer.write(string);
                writer.append("\n");
                writer.flush();
            } catch (IOException exception) {
                System.out.println("Error while writing to file");
            }
        }
    }
}
