package com.zuehlke.haa.gormInSpring.repo

import grails.gorm.annotation.Entity

@Entity
class Graphic extends CollectionItem {
    String config
}
