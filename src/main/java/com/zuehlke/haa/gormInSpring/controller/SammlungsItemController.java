package com.zuehlke.haa.gormInSpring.controller;


import com.zuehlke.haa.gormInSpring.repo.SammlungsItem;
import com.zuehlke.haa.gormInSpring.service.SammlungsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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

  @GetMapping
  public List<SammlungsItemDto> getAll(){
    List<SammlungsItem> sammlungsItems = sammlungsItemService.findAll();
    return sammlungsItems.stream().map(SammlungsItemDto::create).collect(toList());
  }

  @PostMapping
  public SammlungsItemDto add(@RequestBody SammlungsItemDto sammlungsItemDto){
    SammlungsItem sammlungsItem = sammlungsItemService.save(sammlungsItemDto);

    return SammlungsItemDto.create(sammlungsItem);
  }

  @PutMapping("{id}")
  public SammlungsItemDto update(@PathVariable Long id, @RequestBody SammlungsItemDto sammlungsItemDto){
    SammlungsItem sammlungsItem = sammlungsItemService.update(id, sammlungsItemDto);

    return SammlungsItemDto.create(sammlungsItem);
  }
}
