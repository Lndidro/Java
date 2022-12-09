package by.pms.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Cars {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String car_make, car_model;
    private int car_year, expenses;

    public Cars() {}
    public Cars(String car_make, String car_model, int car_year, int expenses) {
        this.car_make = car_make;
        this.car_model = car_model;
        this.car_year = car_year;
        this.expenses = expenses;
    }
}