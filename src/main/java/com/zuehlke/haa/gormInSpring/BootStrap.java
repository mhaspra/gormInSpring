package com.zuehlke.haa.gormInSpring;

import com.zuehlke.haa.gormInSpring.domain.Collection;
import com.zuehlke.haa.gormInSpring.domain.Graphic;
import com.zuehlke.haa.gormInSpring.service.CollectionService;
import com.zuehlke.haa.gormInSpring.service.GraphicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class BootStrap {
  private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
    log.info("Inserted: " + graphicService.findAllAsString());

    insertExampleCollection();
    log.info("Inserted: " + collectionService.findAllAsString());
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
