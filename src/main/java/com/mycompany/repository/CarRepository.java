package com.mycompany.repository;

import com.mycompany.domain.Car;
import com.mycompany.domain.User;

import java.util.List;

public interface CarRepository extends CrudOperations<Long, Car> {

    List<Car> findCarsByName(String query);

    List<Car> findCarFromToPrice(Long from,Long to,String carName);

}
