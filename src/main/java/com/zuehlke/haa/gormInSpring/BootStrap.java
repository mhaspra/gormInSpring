package com.zuehlke.haa.gormInSpring;

import com.zuehlke.haa.gormInSpring.service.SammlungsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootStrap {
  private SammlungsItemService sammlungsItemService;

  @Autowired
  public BootStrap(SammlungsItemService sammlungsItemService) {
    this.sammlungsItemService = sammlungsItemService;
  }

  public void init(){
   System.out.println(sammlungsItemService.test());
  }
}
