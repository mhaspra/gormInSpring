package com.zuehlke.haa.gormInSpring.controller.graphic;


import com.zuehlke.haa.gormInSpring.domain.Graphic;
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

  @RequestMapping(path = "{id}")
  public GraphicDto get(@PathVariable Long id){
    return graphicService.getAsDto(id);
  }

  @RequestMapping
  public List<GraphicDto> getAll(){
    return graphicService.findAllAsDto();
  }

  @RequestMapping(method = RequestMethod.POST)
  public GraphicDto add(@RequestBody GraphicDto graphicDto){
    Graphic graphic = graphicService.save(graphicDto);

    return GraphicDto.create(graphic);
  }

  @RequestMapping(path = "{id}", method = RequestMethod.PUT)
  public GraphicDto update(@PathVariable Long id, @RequestBody GraphicDto graphicDto){
    Graphic graphic = graphicService.update(id, graphicDto);

    return GraphicDto.create(graphic);
  }
}
