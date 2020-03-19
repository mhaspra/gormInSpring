package com.zuehlke.haa.gormInSpring.repo

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
        Graphic.get(id)
    }
}
