package com.mycompany.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Clients {

   private Long id;

   private String name;

   private String surname;

   private String address;

   private Long phone;

   private String passport_series;

   private Long number_passport;

   private Date created;

   private Date changed;

   private String email;

   private Long driver_license_number;

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
   }

}
