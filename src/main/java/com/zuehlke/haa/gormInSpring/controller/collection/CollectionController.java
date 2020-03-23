package com.zuehlke.haa.gormInSpring.controller.collection;

import com.zuehlke.haa.gormInSpring.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("collections")
public class CollectionController {
  private CollectionService collectionService;

  @Autowired
  public CollectionController(CollectionService collectionService) {
    this.collectionService = collectionService;
  }

  @GetMapping("{id}")
  public CollectionDto get(@PathVariable Long id){
    return collectionService.getDto(id);
  }
}
