package com.zuehlke.haa.gormInSpring.domain

import grails.gorm.annotation.Entity
import groovy.transform.ToString

@Entity
@ToString(includeSuper = true, includeNames = true, excludes = ["collections", "description"])
class Graphic extends CollectionItem {
    static final String DISCRIMINATOR = 'graphic'
    static final KEYWORDS_TABLENAME = 'GRAPHIC_KEY_WORDS'
    static final KEYWORDS_COLUMNNAME = 'KEY_WORD'

    String config

    Description description

    Set<String> keyWords = []

    static constraints = {
        description nullable: true
    }

    static mapping = {
        discriminator DISCRIMINATOR
        keyWords joinTable: [name: KEYWORDS_TABLENAME, column: KEYWORDS_COLUMNNAME, key: 'GRAPHIC_ID']
    }
}
