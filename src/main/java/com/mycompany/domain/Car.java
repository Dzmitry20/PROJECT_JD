package com.mycompany.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.sql.Date;
import java.util.Objects;

public class Car {

    private Long id;

    private String name;

    private String model;

    private Date production_date = new Date(System.currentTimeMillis());

    private Float price;


    public Car(){
    }

    public Car(Long id, String name, String model, Date production_date, Float price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.production_date = production_date;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(name, car.name) && Objects.equals(model, car.model) && Objects.equals(production_date, car.production_date) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, model, production_date, price);
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
