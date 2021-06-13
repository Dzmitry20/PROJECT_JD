package com.mycompany.repository.impl;


import com.mycompany.domain.Cars;
import com.mycompany.repository.CarColumn;
import com.mycompany.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class JdbcCarRepository implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Cars> findAll() {
        return jdbcTemplate.query("select * from cars order by id desc", this::getCarRowMapper);
    }

    @Override
    public Cars findOne(Long id) {
        return null;
    }

    @Override
    public Cars save(Cars entity) {
        return null;
    }

    @Override
    public Cars update(Cars entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private Cars getCarRowMapper(ResultSet rs, int i) throws SQLException {
        Cars cars = new Cars();
        cars.setId(rs.getLong(CarColumn.ID));
        cars.setName_car(rs.getString(CarColumn.NAME_CAR));
        cars.setModel(rs.getString(CarColumn.MODEL));
        cars.setBirthday_car(rs.getDate(CarColumn.BIRTHDAY_CAR));
        cars.setColor(rs.getString(CarColumn.COLOR));
        cars.setV_motor(rs.getDouble(CarColumn.V_MOTOR));
        cars.setPower(rs.getDouble(CarColumn.POWER));
        cars.setTransmission(rs.getString(CarColumn.TRANSMISSION));
        cars.setCost_per_day(rs.getDouble(CarColumn.COST_PER_DAY));
        cars.setCreated(rs.getDate(CarColumn.CREATED));
        cars.setChanged(rs.getDate(CarColumn.CHANGED));

        return cars;
    }



}
