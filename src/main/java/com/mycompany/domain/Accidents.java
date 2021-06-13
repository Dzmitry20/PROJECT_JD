package com.mycompany.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public class Accidents {

   private Long id;

   private Long contracts_id;

   private Date date_dtp;

   private String result;

   private Date created;

   private Date changed;

   @Override
   public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
   }
}
