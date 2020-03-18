package com.zuehlke.haa.gormInSpring;

import com.zuehlke.haa.gormInSpring.repo.SammlungsItem;
import com.zuehlke.haa.gormInSpring.service.SammlungsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BootStrap {
  private SammlungsItemService sammlungsItemService;

  @Autowired
  public BootStrap(SammlungsItemService sammlungsItemService) {
    this.sammlungsItemService = sammlungsItemService;
  }

  public void init(){
    insertSammlungsItem("Config A");
    insertSammlungsItem("Config B");
    insertSammlungsItem("Config C");

    System.out.println(sammlungsItemService.findAll()
        .stream()
        .map(item -> item.getId() + ": " + item.getConfig())
        .collect(Collectors.joining(", "))
    );
  }

  private void insertSammlungsItem(String config) {
    SammlungsItem sammlungsItem = new SammlungsItem();
    sammlungsItem.setConfig(config);

    sammlungsItemService.save(sammlungsItem);
  }
}
