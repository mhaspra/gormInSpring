package com.zuehlke.haa.gormInSpring.controller;


import com.zuehlke.haa.gormInSpring.repo.SammlungsItem;
import com.zuehlke.haa.gormInSpring.service.SammlungsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sammlungsItems")
public class SammlungsItemController {
  private SammlungsItemService sammlungsItemService;

  @Autowired
  public SammlungsItemController(SammlungsItemService sammlungsItemService) {
    this.sammlungsItemService = sammlungsItemService;
  }

  @GetMapping("{id}")
  public SammlungsItemDto get(@PathVariable Long id){
    SammlungsItem sammlungsItem = sammlungsItemService.get(id);
    return SammlungsItemDto.create(sammlungsItem);
  }
}
