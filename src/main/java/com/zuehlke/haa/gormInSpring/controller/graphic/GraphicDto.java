package com.zuehlke.haa.gormInSpring.controller.graphic;

import com.zuehlke.haa.gormInSpring.domain.Graphic;
import com.zuehlke.haa.gormInSpring.service.HibernateUtils;

import java.util.Set;

public class GraphicDto {
  private Long id;
  private String author;
  private String config;
  private Set<String> keywords;

  public static GraphicDto create(Graphic graphic){
    GraphicDto dto = new GraphicDto();
    dto.id = graphic.getId();
    dto.author = graphic.getAuthor();
    dto.config = graphic.getConfig();
    dto.keywords = HibernateUtils.uwrapIfProxy(graphic.getKeyWords());

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

  public Set<String> getKeywords() {
    return keywords;
  }
}
