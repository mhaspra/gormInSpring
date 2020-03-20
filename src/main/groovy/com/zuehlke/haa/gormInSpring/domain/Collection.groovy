package com.zuehlke.haa.gormInSpring.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString

import javax.persistence.Id

@Entity
@ToString(includeNames = true, excludes = 'items')
class Collection {
    Long id

    String title

    List<CollectionItem> items = []

    static hasMany = [items: CollectionItem]

    void addGraphics(List<Graphic> graphics){
        graphics.each {
            if(!items.contains(it)){
                items.add(it)
            }
        }
    }
}
