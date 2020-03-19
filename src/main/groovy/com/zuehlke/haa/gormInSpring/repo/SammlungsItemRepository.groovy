package com.zuehlke.haa.gormInSpring.repo

import org.springframework.stereotype.Service

@Service
class SammlungsItemRepository {
    SammlungsItem save(SammlungsItem sammlungsItem){
        return sammlungsItem.save()
    }

    List<SammlungsItem> findAll() {
        return SammlungsItem.findAll()
    }

    SammlungsItem get(Long id){
        SammlungsItem.get(id)
    }
}
