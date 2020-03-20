package com.zuehlke.haa.gormInSpring.domain

import grails.gorm.annotation.Entity

@Entity
class Description {
    Long id

    String text

    Graphic graphic;

    static belongsTo = [graphic: Graphic]
}
