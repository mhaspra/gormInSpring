package com.zuehlke.haa.gormInSpring.controller;


import com.zuehlke.haa.gormInSpring.repo.CollectionItem;
import com.zuehlke.haa.gormInSpring.service.CollectionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("collectionItems")
public class CollectionItemController {
  private CollectionItemService collectionItemService;

  @Autowired
  public CollectionItemController(CollectionItemService collectionItemService) {
    this.collectionItemService = collectionItemService;
  }

  @GetMapping("{id}")
  public CollectionItemDto get(@PathVariable Long id){
    CollectionItem collectionItem = collectionItemService.get(id);
    return CollectionItemDto.create(collectionItem);
  }

  @GetMapping
  public List<CollectionItemDto> getAll(){
    List<CollectionItem> collectionItems = collectionItemService.findAll();
    return collectionItems.stream().map(CollectionItemDto::create).collect(toList());
  }

  @PostMapping
  public CollectionItemDto add(@RequestBody CollectionItemDto collectionItemDto){
    CollectionItem collectionItem = collectionItemService.save(collectionItemDto);

    return CollectionItemDto.create(collectionItem);
  }

  @PutMapping("{id}")
  public CollectionItemDto update(@PathVariable Long id, @RequestBody CollectionItemDto collectionItemDto){
    CollectionItem collectionItem = collectionItemService.update(id, collectionItemDto);

    return CollectionItemDto.create(collectionItem);
  }
}
