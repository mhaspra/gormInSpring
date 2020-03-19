package com.zuehlke.haa.gormInSpring.repo

import com.zuehlke.haa.gormInSpring.domain.Graphic
import org.springframework.stereotype.Service

@Service
class GraphicRepository {
    Graphic save(Graphic graphic){
        return graphic.save()
    }

    List<Graphic> findAll() {
        return Graphic.findAll()
    }

    Graphic get(Long id){
        return Graphic.get(id)
    }
}
