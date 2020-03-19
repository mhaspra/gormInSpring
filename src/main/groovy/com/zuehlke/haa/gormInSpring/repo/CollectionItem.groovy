package com.zuehlke.haa.gormInSpring.repo

import grails.gorm.annotation.Entity

import javax.persistence.Id

@Entity
class CollectionItem {//Use of 'implements GormEntity<CollectionItem>' leads to errors. Do we need that?
    @Id
    Long id
    String config
}
