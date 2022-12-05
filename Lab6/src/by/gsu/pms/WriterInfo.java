package by.gsu.pms;

import java.util.List;

public class WriterInfo {
    public static void writeInfo(List<Car> cars) {
        for (var car: cars) {
            System.out.println(car.toString());
        }
        System.out.println("\n");
    }
}
