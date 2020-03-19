package com.zuehlke.haa.gormInSpring.service;

import com.zuehlke.haa.gormInSpring.controller.GraphicDto;
import com.zuehlke.haa.gormInSpring.domain.Graphic;
import com.zuehlke.haa.gormInSpring.repo.GraphicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GraphicService {
  private GraphicRepository graphicRepository;

  @Autowired
  public GraphicService(GraphicRepository graphicRepository) {
    this.graphicRepository = graphicRepository;
  }

  public void save(Graphic graphic) {
    graphicRepository.save(graphic);
  }

  public Graphic save(GraphicDto graphicDto) {
    Graphic graphic = new Graphic();
    graphic.setAuthor(graphicDto.getAuthor());
    graphic.setConfig(graphicDto.getConfig());

    return graphicRepository.save(graphic);
  }

  public List<Graphic> findAll() {
    return graphicRepository.findAll();
  }

  public Graphic get(Long id){
    return graphicRepository.get(id);
  }

  public Graphic update(Long id, GraphicDto graphicDto) {
    Graphic graphic = graphicRepository.get(id);
    graphic.setAuthor(graphicDto.getAuthor());
    graphic.setConfig(graphicDto.getConfig());

    return graphicRepository.save(graphic);
  }

  //To test ToString in a method with a transaction
  public String findAllAsString() {
    return findAll()
        .stream()
        .map(Object::toString)
        .collect(Collectors.joining(", "));
  }
}
