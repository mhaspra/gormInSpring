package com.zuehlke.haa.gormInSpring.controller;

import com.zuehlke.haa.gormInSpring.repo.CollectionItem;
import com.zuehlke.haa.gormInSpring.repo.Graphic;

public class GraphicDto {
  private Long id;
  private String author;
  private String config;

  public static GraphicDto create(Graphic graphic){
    GraphicDto dto = new GraphicDto();
    dto.id = graphic.getId();
    dto.author = graphic.getAuthor();
    dto.config = graphic.getConfig();

    return dto;
  }

  public Long getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public String getConfig() {
    return config;
  }
}
