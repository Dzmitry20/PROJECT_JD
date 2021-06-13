package com.mycompany.repository;

import com.mycompany.domain.Car;
import com.mycompany.domain.Cars;
import com.mycompany.domain.User;

import java.util.List;

public interface CarRepository extends CrudOperations<Long, Cars> {

//    List<Cars> findCarsByName(String query);

//    List<Cars> findCarFromToPrice(Long from,Long to,String carName);

}
