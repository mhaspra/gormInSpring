package com.zuehlke.haa.gormInSpring.repo

import org.springframework.stereotype.Service

@Service
class CollectionItemRepository {
    CollectionItem save(CollectionItem collectionItem){
        return collectionItem.save()
    }

    List<CollectionItem> findAll() {
        return CollectionItem.findAll()
    }

    CollectionItem get(Long id){
        CollectionItem.get(id)
    }
}
