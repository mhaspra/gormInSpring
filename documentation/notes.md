# Notes for grails2spring
## Versionen
* gorm: 7.0.1.RELEASE //Minimum Version für Java 11 (GP: 5.0.4)
* hibernate: 5.4.12.Final (GP: 4.3.11.Final)
* spring-boot: 2.2.5.RELEASE (GP: 1.3.3.RELEASE)
* spring-core: 5.2.4.RELEASE (GP: 4.2.5.RELEASE)

## Mögliche Probleme gemäss gorm Dokumentation
###Changes to Proxy Handling
GORM no longer creates custom proxy factories nor automatically unwraps Hibernate proxies.

This makes it more consistent to the way regular Hibernate behaves and reduces the complexity required at the framework level.

You may need to alter instanceof checks are manually unwrap proxies in certain cases.

###Module grails-validation Deprecated and Removed
In GORM 6.x the grails-validation module was deprecated and replaced by grails-datastore-gorm-validation.
   
Deprecated interfaces were maintained for backwards compatibility. In GORM 7.0 these deprecated classes have been removed and all dependency on grails-validation removed.

###Transactions Now Required for all Operations
Previous versions of Hibernate allowed read operations to be executed without the presence of a declaration transaction.
   
Hibernate 5.2 and above require the presence of an active transaction. If see a javax.persistence.TransactionRequiredException exception it means your method lacks a @Transactional annotation around it.

##Spring with gorm
###Usefull Links
https://guides.grails.org/gorm-without-grails/guide/index.html

###Set-Up Domain
We are using GORM outside of Grails. Because of that, we need to annotate our domain classes with the grails.gorm.annotation.Entity. Additionally we implement the GormEntity trait. It is merely to aid IDE support of GORM outside of Grails.

###Probleme

####Groovy Code in Java Klassen nicht verfügbar
Wenn ich das Projekt builde, dann bekomme für groovy Klassen die in Java benutzt werden:
````java
Error:(3, 44) java: package com.zuehlke.haa.grails2spring.domain does not exist
`````
Lösung:
Der Groovy Compiler muss sowohl die java als auch die Groovy Klassen kompilieren.
Das kann man erreichen indem man folgendes im build.gradle hinzufügt:
```groovy
sourceSets {
    main {
        java { srcDirs = [] }// no source dirs for the java compiler
        groovy { srcDirs = ["src/main/java", "src/main/groovy"] }//compile everything in src/ with groovyc
    }
}
```

###Log
####18.03.2020
Am Anfang hat es nicht so richtig funktionert, es kamen Fehler mit dem DirtyChecker von Gorm und mit einer doppelten importieren Library.
Nach einem erneute Set-Up hat es dann aber funktioniert. Leider war der Guide grails only, solche nur mit Java gibt es nicht.

Bisher sieht es aber gut aus. (Offen ist noch die Konfiguration, aus irgendeinem Grund hat es nur im yml funktioniert. Das sollte aber lösbar sein)

####19.03.2020
Um Java 11 dann wirklich zu enablen braucht man midestens gorm 7, das hat zur Folge dass man mindestens hibernate 5.3 und mindestens spring 5.2 braucht

##Backlog
* Changes to Proxy Handling anschauen
* Eh Cache anschauen (ist das der richtige?)
* Spock Tests ausprobieren
