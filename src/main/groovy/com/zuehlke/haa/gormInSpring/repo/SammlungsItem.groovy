package com.zuehlke.haa.gormInSpring.repo

import grails.gorm.annotation.Entity
import groovy.transform.ToString

import javax.persistence.Id

@Entity
class SammlungsItem {//Use of GormEntity is merely to aid IDE support outside of Grails.
    @Id
    Long id
    String config
}
