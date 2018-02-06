# FOOL

Progetto realizzabile a diversi livelli:
* sola estensione del linguaggio visto a lezione con operatori "<=", ">=", "||", "&&", "/", "-" e "!", con stesso significato che hanno in C/Java (2 punti)
* ulteriore estensione con
  * passaggio higher-order di funzioni (4 punti totali)
  * object-orientation a diversi livelli
* senza ereditarietà (4 punti totali)
* con ereditarietà (5 punti totali)
* con ereditarietà e ottimizzazioni (6 punti totali)
  * sia object orientation ad uno dei tre livelli che higher-order (1 punto aggiuntivo al punteggio del livello)

## Email del prof con configurazione

Cari studenti di LCMC,

     ecco sotto le istruzioni per installare il plugin ANTLR 4 in Eclipse.
(da fare per il laboratorio di questo venerdì in caso vogliate usare i vostri computer)

Cordialmente,

      Mario Bravetti

INSTALLAZIONE PLUGIN ECLIPSE "ANTLR 4 IDE 0.3.6" 
(da effettuare per i computer personali)

Si installa il plugin entrando in eclipse e poi:
menù help -> eclipse Marketplace -> ANTLR 4 IDE 0.3.6

Si crea nel disco fisso del computer una directory ad un percorso breve
(facile da scrivere, es "C:\antlr\") ed accedibile in
lettura agli utenti del PC che contenga:
- antlr-runtime-4.7.jar
- antlr-4.7-complete.jar
scaricabili da:
http://www.antlr.org/download/antlr-runtime-4.7.jar
http://www.antlr.org/download/antlr-4.7-complete.jar

CONFIGURAZIONE PULG-IN

Seguire le istruzioni di configurazione che vengono date in laboratorio

## Prima configurazione

CREAZIONE PROGETTI

File->New->Java Project
(controllare che "Project layout" sia impostato a:
"Create separate folders for sources and class files")

Copiare (o creare) nella directory principale del progetto un file ".g4" e poi aprirlo e salvarlo (dopo aver fatto una qualche modifica) in modo che si attivi la funzionalità ANTLR 4 per il progetto 

CONFIGURAZIONE WORKSPACE (da fare un'unica volta sul primo progetto creato)

destro sul progetto->Properties->ANTLR 4->Tool->Configure Workspace Settings e poi:
- fare ->Add e selezionare "antlr-4.7-complete.jar" andando dentro a "C:\antlr"
- dare la spunta alla versione 4.7 appena aggiunta
- nelle opzioni: indicare "./src" come Directory, inoltre "Generate a parse tree listener/Generate parse tree visitors" non devono avere la spunta

-----------------------------
ESECUZIONE CODICE COMPILATORE
-----------------------------

CONFIGURAZIONE ECLIPSE (da fare un'unica volta, creazione user library ANTLR runtime)

Window->Preferences->Java->Build Path->User Libraries
prima
->new (e scrivere "ANTLR runtime")
e poi (andando su libreria creata)
->Add External Jars (e selezionare "antlr-runtime-4.7.jar" andando dentro a "C:\antlr")

CONFIGURAZIONE PROGETTO (aggiunge user library "ANTLR runtime" a un progetto)

destro sul progetto->Build Path->Add Libraries->User Library
(e selezionare "ANTLR runtime")


