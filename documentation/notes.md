# Notes for grails2spring
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
Nach einem erneute Set-Up hat es dann aber funktioniert. Leider ist der Guide grails only solche nur mit Java gibt es nicht.

Bisher sieht es aber gut aus. (Offen ist noch die Konfiguration, aus irgendeinem Grund hat es nur im yml funktioniert. Das sollte aber lösbar sein)