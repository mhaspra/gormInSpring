package com.zuehlke.haa.gormInSpring.service;

import com.zuehlke.haa.gormInSpring.controller.CollectionItemDto;
import com.zuehlke.haa.gormInSpring.repo.CollectionItem;
import com.zuehlke.haa.gormInSpring.repo.CollectionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollectionItemService {
  private CollectionItemRepository collectionItemRepository;

  @Autowired
  public CollectionItemService(CollectionItemRepository collectionItemRepository) {
    this.collectionItemRepository = collectionItemRepository;
  }

  public void save(CollectionItem collectionItem) {
    collectionItemRepository.save(collectionItem);
  }

  public CollectionItem save(CollectionItemDto collectionItemDto) {
    CollectionItem collectionItem = new CollectionItem();
    collectionItem.setConfig(collectionItemDto.getConfig());

    return collectionItemRepository.save(collectionItem);
  }

  public List<CollectionItem> findAll() {
    return collectionItemRepository.findAll();
  }

  public CollectionItem get(Long id){
    return collectionItemRepository.get(id);
  }

  public CollectionItem update(Long id, CollectionItemDto collectionItemDto) {
    CollectionItem collectionItem = collectionItemRepository.get(id);
    collectionItem.setConfig(collectionItemDto.getConfig());

    return collectionItemRepository.save(collectionItem);
  }
}
