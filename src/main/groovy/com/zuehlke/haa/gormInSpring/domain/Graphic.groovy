package com.zuehlke.haa.gormInSpring.domain

import grails.gorm.annotation.Entity

@Entity
class Graphic extends CollectionItem {
    String config
}
