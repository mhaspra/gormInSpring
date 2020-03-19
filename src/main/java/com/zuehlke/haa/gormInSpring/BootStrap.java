package com.zuehlke.haa.gormInSpring;

import com.zuehlke.haa.gormInSpring.repo.CollectionItem;
import com.zuehlke.haa.gormInSpring.service.CollectionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BootStrap {
  private CollectionItemService collectionItemService;

  @Autowired
  public BootStrap(CollectionItemService collectionItemService) {
    this.collectionItemService = collectionItemService;
  }

  public void init(){
    insertCollectionItem("Config A");
    insertCollectionItem("Config B");
    insertCollectionItem("Config C");

    System.out.println(collectionItemService.findAll()
        .stream()
        .map(item -> item.getId() + ": " + item.getConfig())
        .collect(Collectors.joining(", "))
    );
  }

  private void insertCollectionItem(String config) {
    CollectionItem collectionItem = new CollectionItem();
    collectionItem.setConfig(config);

    collectionItemService.save(collectionItem);
  }
}
