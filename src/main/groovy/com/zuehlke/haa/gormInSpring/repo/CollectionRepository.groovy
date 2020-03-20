package com.zuehlke.haa.gormInSpring.repo

import com.zuehlke.haa.gormInSpring.domain.Collection
import org.springframework.stereotype.Service

@Service
class CollectionRepository {
    void save(Collection collection) {
        collection.save()
    }

    Collection get(Long id) {
        return Collection.get(id)
    }

    List<Collection> findAll() {
        return Collection.findAll()
    }
}
