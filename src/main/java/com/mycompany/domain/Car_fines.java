package com.mycompany.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.awt.geom.Arc2D;
import java.util.Date;

public class Car_fines {

   private Long id;

   private String name_fine;

   private Long contracts_id;

   private Double amount_fine;

   private Date created;

   private Date changed;

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
   }
}
