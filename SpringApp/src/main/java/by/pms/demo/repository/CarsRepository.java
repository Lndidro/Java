package by.pms.demo.repository;

import by.pms.demo.entity.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepository extends CrudRepository<Cars, Long> {
}
