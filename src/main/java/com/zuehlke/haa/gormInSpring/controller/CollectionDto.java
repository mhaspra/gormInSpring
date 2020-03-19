package com.zuehlke.haa.gormInSpring.controller;

import com.zuehlke.haa.gormInSpring.domain.Collection;
import com.zuehlke.haa.gormInSpring.domain.Graphic;
import org.hibernate.internal.CoreMessageLogger_$logger;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionDto {
  private Long id;
  private String title;
  private List<GraphicDto> items;

  public static CollectionDto create(Collection collection) {
    CollectionDto collectionDto = new CollectionDto();
    collectionDto.id = collection.getId();
    collectionDto.title = collection.getTitle();
    collectionDto.items = collection.getItems().stream().map(it -> (Graphic) it).map(GraphicDto::create).collect(Collectors.toList());

    return collectionDto;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<GraphicDto> getItems() {
    return items;
  }
}
