package com.zuehlke.haa.gormInSpring.repo

import org.springframework.stereotype.Service

@Service
class SammlungsItemRepository {
    void save(SammlungsItem sammlungsItem){
        SammlungsItem.saveAll([sammlungsItem])
    }

    List<SammlungsItem> findAll() {
        return SammlungsItem.findAll()
    }

    SammlungsItem get(Long id){
        SammlungsItem.get(id)
    }
}
