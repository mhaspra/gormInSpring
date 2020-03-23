package com.zuehlke.haa.gormInSpring.service;

import com.zuehlke.haa.gormInSpring.controller.graphic.GraphicDto;
import com.zuehlke.haa.gormInSpring.domain.Graphic;
import com.zuehlke.haa.gormInSpring.repo.GraphicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
    graphic.setKeyWords(graphicDto.getKeywords());

    return graphicRepository.save(graphic);
  }

  public List<Graphic> findAll() {
    return graphicRepository.findAll();
  }

  public List<GraphicDto> findAllAsDto(){
    List<Graphic> graphics = findAll();
    return graphics.stream().map(GraphicDto::create).collect(toList());
  }

  public Graphic get(Long id){
    return graphicRepository.get(id);
  }

  public GraphicDto getAsDto(Long id){
    Graphic gra = get(id);
    return GraphicDto.create(gra);
  }

  public Graphic update(Long id, GraphicDto graphicDto) {
    Graphic graphic = graphicRepository.get(id);
    graphic.setAuthor(graphicDto.getAuthor());
    graphic.setConfig(graphicDto.getConfig());
    graphic.setKeyWords(graphicDto.getKeywords());

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
