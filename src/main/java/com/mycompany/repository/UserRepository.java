package com.mycompany.repository;

import com.mycompany.domain.User;


import java.util.List;

public interface UserRepository extends CrudOperations<Long, User> {

    List<User> findUsersByQuery(String query);

    Double getUserExpensiveCarPrice(Integer userId);

    List<User> findWeightFromTo(Long from,Long to);

}
