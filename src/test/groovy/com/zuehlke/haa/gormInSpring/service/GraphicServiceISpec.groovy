package com.zuehlke.haa.gormInSpring.service

import com.zuehlke.haa.gormInSpring.GormInSpringApplication
import com.zuehlke.haa.gormInSpring.domain.Graphic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@SpringApplicationConfiguration(GormInSpringApplication.class)
@WebIntegrationTest
@ActiveProfiles('test')
class GraphicServiceISpec extends Specification{
    @Autowired
    GraphicService graphicService
    @PersistenceContext
    private EntityManager entityManager

    void "graphic can be saved"() {
        given:
        Graphic graphic = new Graphic()
        graphic.setAuthor("Mr. Spock");
        graphic.setConfig("Test Config");

        when:
        graphicService.save(graphic);

        then:
        graphicService.findAll().size() == 1
    }

    void "graphic can be retrieved"() {
        given:
        Graphic graphic = new Graphic()
        graphic.setAuthor("Mr. Spock");
        graphic.setConfig("Test Config");
        graphic.save()

        and:
        entityManager.clear()

        when:
        Graphic loadedGraphic = graphicService.get(graphic.getId());

        then:
        loadedGraphic.getAuthor() == graphic.getAuthor()
        loadedGraphic.getConfig() == graphic.getConfig()
    }
}
