package by.gsu.pms;

import java.util.Comparator;

import by.gsu.pms.Car;

public class ComparatorByBrand implements Comparator<Car> {
    @Override
    public int compare(Car object1, Car object2) {
        if (object1 == null && object2 == null) {
            return 0;
        }
        if (object2 != null && object1 == null) {
            return 1;
        }
        if (object2 == null) {
            return -1;
        }
        String string1 = object1.getBrand();
        String string2 = object2.getBrand();
        if (string1 == null && string2 == null) {
            return 0;
        }
        if (string2 != null && string1 == null) {
            return 1;
        }
        if (string2 == null) {
            return -1;
        }
        return string1.compareTo(string2);
    }
}
