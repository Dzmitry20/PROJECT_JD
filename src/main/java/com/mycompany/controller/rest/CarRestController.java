package com.mycompany.controller.rest;


import com.mycompany.domain.Cars;
import com.mycompany.repository.impl.JdbcCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/car")
@RequiredArgsConstructor
public class CarRestController {

    private  final JdbcCarRepository jdbcCarRepository;


    @GetMapping("/all")
    public List<Cars> findAll() {
        System.out.println("In rest controller");
        return jdbcCarRepository.findAll();
    }
}
