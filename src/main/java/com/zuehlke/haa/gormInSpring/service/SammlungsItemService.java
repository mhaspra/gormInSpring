package com.zuehlke.haa.gormInSpring.service;

import com.zuehlke.haa.gormInSpring.controller.SammlungsItemDto;
import com.zuehlke.haa.gormInSpring.repo.SammlungsItem;
import com.zuehlke.haa.gormInSpring.repo.SammlungsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SammlungsItemService {
  private SammlungsItemRepository sammlungsItemRepository;

  @Autowired
  public SammlungsItemService(SammlungsItemRepository sammlungsItemRepository) {
    this.sammlungsItemRepository = sammlungsItemRepository;
  }

  public void save(SammlungsItem sammlungsItem) {
    sammlungsItemRepository.save(sammlungsItem);
  }

  public SammlungsItem save(SammlungsItemDto sammlungsItemDto) {
    SammlungsItem sammlungsItem = new SammlungsItem();
    sammlungsItem.setConfig(sammlungsItemDto.getConfig());

    return sammlungsItemRepository.save(sammlungsItem);
  }

  public List<SammlungsItem> findAll() {
    return sammlungsItemRepository.findAll();
  }

  public SammlungsItem get(Long id){
    return sammlungsItemRepository.get(id);
  }
}
