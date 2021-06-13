package com.mycompany.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Orders {

   private Long id;

   private Long auto_id;

   private Long clients_id;

   private Date received_date;

   private Date return_data;

   private Date created;

   private Date changed;

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
   }
}
