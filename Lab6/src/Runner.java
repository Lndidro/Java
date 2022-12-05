import by.gsu.pms.*;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        var cars = ReaderFromFile.readData();
        WriterInfo.writeInfo(cars);

        cars.sort(new ComparatorByBrand());

        WriterInfo.writeInfo(cars);
        WriterToFile.writeToFile(cars);


        for (Car car: cars) {
            if (car != null &&
                car.getBrand().equals("Lambo") &&
                car.getModel().equals("Aventador") &&
                car.getYearOfManufacture() == 2021) {
                System.out.println(car);
            }
        }
    }
}
