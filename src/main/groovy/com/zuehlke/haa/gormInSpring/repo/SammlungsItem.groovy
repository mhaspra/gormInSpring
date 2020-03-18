package com.zuehlke.haa.gormInSpring.repo

import grails.gorm.annotation.Entity
import groovy.transform.ToString

import javax.persistence.Id

@Entity
class SammlungsItem {
    @Id
    Long id
    String config
}
