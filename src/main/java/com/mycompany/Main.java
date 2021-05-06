package com.mycompany;

import com.mycompany.repository.impl.CarRepositoryImpl;
import com.mycompany.repository.impl.UserRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        System.out.println(new UserRepositoryImpl().getUserExpensiveCarPrice(4));
        System.out.println(new CarRepositoryImpl().findAll());

    }
}