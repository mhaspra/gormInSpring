package com.zuehlke.haa.gormInSpring.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString

import javax.persistence.Id

@Entity
abstract class CollectionItem {
    Long id

    String author

    Set<Collection> collections = []

    static belongsTo = Collection
    static hasMany = [collections      : Collection]

}
