package com.zuehlke.haa.gormInSpring;

import com.zuehlke.haa.gormInSpring.repo.CollectionItem;
import com.zuehlke.haa.gormInSpring.repo.Graphic;
import com.zuehlke.haa.gormInSpring.service.GraphicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BootStrap {
  private GraphicService graphicService;

  @Autowired
  public BootStrap(GraphicService graphicService) {
    this.graphicService = graphicService;
  }

  public void init(){
    insertExampleGraphics("Albert", "Config A");
    insertExampleGraphics("Betty", "Config B");
    insertExampleGraphics("Charles", "Config C");

    System.out.println("Inserted: " + graphicService.findAll()
        .stream()
        .map(item -> item.getId() + ": " + item.getConfig())
        .collect(Collectors.joining(", "))
    );
  }

  private void insertExampleGraphics(String author, String config) {
    Graphic graphic = new Graphic();
    graphic.setAuthor(author);
    graphic.setConfig(config);

    graphicService.save(graphic);
  }
}
