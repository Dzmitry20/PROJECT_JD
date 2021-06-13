package com.mycompany.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Contracts {

   private String id;

   private Date date_contract;

   private Date date_end;

   private Double price;

   private Long order_id;

   private Date created;

   private Date changed;

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
   }
}
