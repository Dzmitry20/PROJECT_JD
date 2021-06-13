package com.mycompany.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

@Data

public class Cars {

    private Long id;

    private String name_car;

    private String model;

    private Date birthday_car;

    private String color;

    private Double v_motor;

    private Double power;

    private String transmission;

    private Double cost_per_day;

    private Date created;

    private Date changed;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
