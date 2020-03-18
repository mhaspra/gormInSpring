package com.zuehlke.haa.gormInSpring.service;

import com.zuehlke.haa.gormInSpring.repo.SammlungsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SammlungsItemService {
  private SammlungsItemRepository sammlungsItemRepository;

  @Autowired
  public SammlungsItemService(SammlungsItemRepository sammlungsItemRepository) {
    this.sammlungsItemRepository = sammlungsItemRepository;
  }

  public String test() {
    return "Hi Service: " + sammlungsItemRepository.test();
  }
}
