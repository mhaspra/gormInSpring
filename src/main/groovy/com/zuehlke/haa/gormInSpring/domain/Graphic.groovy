package com.zuehlke.haa.gormInSpring.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString

@Entity
@ToString(includeSuper = true, includeNames = true)
class Graphic extends CollectionItem {
    String config
}
