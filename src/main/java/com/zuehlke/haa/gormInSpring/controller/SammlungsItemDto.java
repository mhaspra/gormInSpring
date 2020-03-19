package com.zuehlke.haa.gormInSpring.controller;

import com.zuehlke.haa.gormInSpring.repo.SammlungsItem;

public class SammlungsItemDto {
  private Long id;
  private String config;

  public static SammlungsItemDto create(SammlungsItem sammlungsItem){
    SammlungsItemDto dto = new SammlungsItemDto();
    dto.id = sammlungsItem.getId();
    dto.config = sammlungsItem.getConfig();

    return dto;
  }

  public Long getId() {
    return id;
  }

  public String getConfig() {
    return config;
  }
}
