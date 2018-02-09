# FOOL #

## OBIETTIVO DEL PROGETTO ##
* Il progetto consiste nella realizzazione di un compilatore per il Functional and Object Oriented Language la cui sintassi è definita nel file FOOL.g4 allegato a queste slides.
* Il linguaggio è una estensione con nuovi operatori, passaggio (higher-order) di funzioni e gestione dell’object orientation della versione di base sviluppata in laboratorio.
* Il compilatore da realizzare deve produrre codice per la Stack Virtual Machine (SVM) sviluppata a lezione (da non modificare!!)

## DIVERSI LIVELLI DI REALIZZAZIONE ##

Progetto realizzabile a diversi livelli:

* sola estensione del linguaggio visto a lezione con operatori "<=", ">=", "||", "&&", "/", "-" e "!", con stesso significato che hanno in C/Java (2 punti)
* ulteriore estensione con
  * passaggio higher-order di funzioni (4 punti totali)
  * object-orientation a diversi livelli
* senza ereditarietà (4 punti totali)
* con ereditarietà (5 punti totali)
* con ereditarietà e ottimizzazioni (6 punti totali)
  * sia object orientation ad uno dei tre livelli che higher-order (1 punto aggiuntivo al punteggio del livello)

## INSTALLAZIONE PLUGIN ECLIPSE "ANTLR 4 IDE 0.3.6" ##

Si installa il plugin entrando in eclipse e poi:

menu ``help`` -> ``eclipse Marketplace`` -> ``ANTLR 4 IDE 0.3.6``

Si crea nel disco fisso del computer una directory ad un percorso breve (facile da scrivere, es "``C:\antlr\``") ed accedibile in lettura agli utenti del PC che contenga:

* [antlr-runtime-4.7.jar](http://www.antlr.org/download/antlr-runtime-4.7.jar)
* [antlr-4.7-complete.jar](http://www.antlr.org/download/antlr-4.7-complete.jar)

## CONFIGURAZIONE PULG-IN ##

### CREAZIONE PROGETTI ###

``File`` -> ``New`` -> ``Java Project`` (controllare che "``Project layout``" sia impostato a: "``Create separate folders for sources and class files``")

Copiare (o creare) nella directory principale del progetto un file ".g4" e poi aprirlo e salvarlo (dopo aver fatto una qualche modifica) in modo che si attivi la funzionalità ANTLR 4 per il progetto 

### CONFIGURAZIONE WORKSPACE ###

Tasto destro sul progetto -> ``Properties`` -> ``ANTLR 4`` -> ``Tool`` -> ``Configure Workspace Settings`` e poi:
* fare -> ``Add`` e selezionare "``antlr-4.7-complete.jar``" andando dentro a "``C:\antlr``"
* dare la spunta alla versione 4.7 appena aggiunta
* nelle opzioni: indicare "``./src``" come Directory, inoltre "``Generate a parse tree listener``" e "``Generate parse tree visitors``" non devono avere la spunta.

## ESECUZIONE CODICE COMPILATORE ##

### CONFIGURAZIONE ECLIPSE ###

``Window`` -> ``Preferences`` -> ``Java`` -> ``Build Path`` -> ``User Libraries``

prima

-> ``new`` (e scrivere "``ANTLR runtime``")

e poi (andando su libreria creata)

-> ``Add External Jars`` (e selezionare "``antlr-runtime-4.7.jar``" andando dentro a "``C:\antlr``")

### CONFIGURAZIONE PROGETTO ###

Tasto destro sul progetto -> ``Build Path`` -> ``Add Libraries`` -> ``User Library`` (e selezionare "``ANTLR runtime``")
