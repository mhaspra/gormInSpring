package com.zuehlke.haa.gormInSpring.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString

@Entity
@ToString(includeSuper = true, includeNames = true, excludes = ["collections", "description"])
class Graphic extends CollectionItem {
    String config

    Description description

    static constraints = {
        description nullable: true
    }
}
