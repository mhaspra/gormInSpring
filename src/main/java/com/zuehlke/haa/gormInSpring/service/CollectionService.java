package com.zuehlke.haa.gormInSpring.service;

import com.zuehlke.haa.gormInSpring.controller.CollectionDto;
import com.zuehlke.haa.gormInSpring.domain.Collection;
import com.zuehlke.haa.gormInSpring.repo.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CollectionService {
  private CollectionRepository collectionRepository;

  @Autowired
  public CollectionService(CollectionRepository collectionRepository) {
    this.collectionRepository = collectionRepository;
  }


  public void save(Collection collection) {
    collectionRepository.save(collection);
  }

  public Collection get(Long id) {
    return collectionRepository.get(id);
  }

  public CollectionDto getDto(Long id) {
    Collection collection = get(id);

    return CollectionDto.create(collection);
  }

  public List<Collection> findAll() {
    return collectionRepository.findAll();
  }
}
