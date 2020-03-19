package com.zuehlke.haa.gormInSpring.repo

import grails.gorm.annotation.Entity
import groovy.transform.ToString

import javax.persistence.Id

@Entity
abstract class CollectionItem {//Use of 'implements GormEntity<CollectionItem>' leads to errors. Do we need that?
    @Id
    Long id
    String author
}
