package com.zuehlke.haa.gormInSpring.controller;

import com.zuehlke.haa.gormInSpring.repo.CollectionItem;

public class CollectionItemDto {
  private Long id;
  private String config;

  public static CollectionItemDto create(CollectionItem collectionItem){
    CollectionItemDto dto = new CollectionItemDto();
    dto.id = collectionItem.getId();
    dto.config = collectionItem.getConfig();

    return dto;
  }

  public Long getId() {
    return id;
  }

  public String getConfig() {
    return config;
  }
}
