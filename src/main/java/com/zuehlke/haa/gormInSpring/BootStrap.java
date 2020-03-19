package com.zuehlke.haa.gormInSpring;

import com.zuehlke.haa.gormInSpring.domain.Collection;
import com.zuehlke.haa.gormInSpring.domain.Graphic;
import com.zuehlke.haa.gormInSpring.service.CollectionService;
import com.zuehlke.haa.gormInSpring.service.GraphicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BootStrap {
  private GraphicService graphicService;
  private CollectionService collectionService;

  @Autowired
  public BootStrap(GraphicService graphicService, CollectionService collectionService) {
    this.graphicService = graphicService;
    this.collectionService = collectionService;
  }

  public void init(){
    insertExampleGraphics("Albert", "Config A");
    insertExampleGraphics("Betty", "Config B");
    insertExampleGraphics("Charles", "Config C");
    System.out.println("Inserted: " + graphicService.findAllAsString());

    insertExampleCollection();
    System.out.println("Inserted: " + collectionService.findAllAsString());
  }

  private void insertExampleGraphics(String author, String config) {
    Graphic graphic = new Graphic();
    graphic.setAuthor(author);
    graphic.setConfig(config);

    graphicService.save(graphic);
  }

  private void insertExampleCollection() {
    Collection collection = new Collection();
    collection.setTitle("Example Collection");
    List<Graphic> graphics = graphicService.findAll();
    collection.addGraphics(graphics);

    collectionService.save(collection);
  }
}
