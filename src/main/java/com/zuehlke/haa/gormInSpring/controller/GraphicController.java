package com.zuehlke.haa.gormInSpring.controller;


import com.zuehlke.haa.gormInSpring.repo.CollectionItem;
import com.zuehlke.haa.gormInSpring.repo.Graphic;
import com.zuehlke.haa.gormInSpring.service.GraphicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("graphics")
public class GraphicController {
  private GraphicService graphicService;

  @Autowired
  public GraphicController(GraphicService graphicService) {
    this.graphicService = graphicService;
  }

  @GetMapping("{id}")
  public GraphicDto get(@PathVariable Long id){
    Graphic gra = graphicService.get(id);
    return GraphicDto.create(gra);
  }

  @GetMapping
  public List<GraphicDto> getAll(){
    List<Graphic> graphics = graphicService.findAll();
    return graphics.stream().map(GraphicDto::create).collect(toList());
  }

  @PostMapping
  public GraphicDto add(@RequestBody GraphicDto graphicDto){
    Graphic graphic = graphicService.save(graphicDto);

    return GraphicDto.create(graphic);
  }

  @PutMapping("{id}")
  public GraphicDto update(@PathVariable Long id, @RequestBody GraphicDto graphicDto){
    Graphic graphic = graphicService.update(id, graphicDto);

    return GraphicDto.create(graphic);
  }
}
