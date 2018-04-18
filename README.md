# FOOL #

## OBIETTIVO DEL PROGETTO ##
* Il progetto consiste nella realizzazione di un compilatore per il Functional and Object Oriented Language la cui sintassi è definita nel file FOOL.g4 allegato a queste slides.
* Il linguaggio è una estensione con nuovi operatori, passaggio (higher-order) di funzioni e gestione dell’object orientation della versione di base sviluppata in laboratorio.
* Il compilatore da realizzare deve produrre codice per la Stack Virtual Machine (SVM) sviluppata a lezione (da non modificare!!)

## DIVERSI LIVELLI DI REALIZZAZIONE ##

Progetto realizzabile a diversi livelli:

* sola estensione del linguaggio visto a lezione con operatori, con stesso significato che hanno in C/Java (2 punti):
    - [X] "<=", 
    - [X] ">=", 
    - [X] "||", 
    - [X] "&&", 
    - [X] "/", 
    - [X] "-",
    - [X] "!"
* ulteriore estensione con
     - passaggio higher-order di funzioni (4 punti totali)
         + [ ] interfaccia DecNode con metodo getSymType() che implementano tutte: VarNode, FunNode, ParNode
         + [ ] getSymType() su un DecNode deve essere implementato in modo che ritorni il tipo messo in Symbol Table
             * [ ] per FunNode prevedere un campo symType dove memorizzarlo
         + [ ] per i tipi "arrow" creare degli ArrowTypeNode (che risulteranno possibilmente annidati nei parametri)
         + [ ] STentry: invariata
             * [ ] ora, oltre agli ID di funzione, anche gli ID di variabili/parametri potranno avere tipo funzionale ArrowTypeNode
         + [ ] Durante il parsing dei parametri e delle dichiarazioni: incremento/decremento offset deve tener conto che gli ID di tipo funzionale occupano offset doppio
         + [X] isSubtype() in FOOLlib ora deve gestire (oltre a "bool" sottotipo di "int") tipi funzionali ArrowTypeNode
             * [ ] entrambi devono essere ArrowTypeNode con stesso numero di paramteri e deve valere:
                 - [ ] relazione di co-varianza sul tipo di ritorno
                 - [ ] relazione di contro-varianza sul tipo dei parametri
         + [ ] espressioni:
             * [X] IdNode -> ID, ora ammettere anche un ID con tipo funzionale! (nome di funzione o var/par di tipo funzionale)
             * [X] EqualNode -> exp1 == exp2, non consentire l'uso di espressioni expi con tipi funzionali (dovrei confrontare coppie di valori)
             * [X] CallNode -> ID() check invariato: il tipo dell’ID deve essere funzionale (nome di funzione o var/par di tipo funzionale)
             * [ ] Dichiarazioni invariate
         + [ ] FunNode
             * [ ] codice ritornato: due cose sono messe nello stack, nell'ordine
                 1. indir (fp) a questo AR (in reg $fp)
                 2. (finisce a offset-1) indir della funzione (etichetta generata)
             * [ ] codice della funzione:
                 - in caso tra i parametri o le dichiarazioni vi siano ID di tipo funzionale (usare getSymType() su DecNode) si devono deallocare due cose dallo stack (con due "pop")
         + [ ] VarNode invariato
             * [ ] ritorna codice generato da sua inizializzazione che metterà due cose in stack se var è di tipo funzionale
                 - si vedano a riguardo espressioni nel seguito (IdNode)
         + [ ] IdNode -> ID
             * se il tipo non è funzionale, ritorna codice invariato
             * se lo è, due cose sono messe nello stack, recuperandole come valori dall'AR dove è dichiarato l'ID, con meccanismo usuale di risalita catena statica; nell'ordine:
                 1. indir (fp) ad AR dichiaraz. funzione (recuperato a offset ID)
                 2. indir funzione (recuperato a offset ID - 1)
         + [ ] CallNode -> ID()
             * codice ritornato modificato: due cose recuperate come valori dall'AR dove è dichiarato l'ID con meccanismo usuale di risalita catena statica
                 - indir (fp) ad AR dichiaraz. funzione (recuperato a offset ID)
                     + usato per settare nuovo Access Link (AL)
                 - indir funzione (recuperato a offset ID - 1)
                     + usato per saltare a codice funzione
     - object-orientation a diversi livelli
         + senza ereditarietà (4 punti totali)
         + con ereditarietà (5 punti totali)
         + con ereditarietà e ottimizzazioni (6 punti totali)
     - sia object orientation ad uno dei tre livelli che higher-order (1 punto aggiuntivo al punteggio del livello)

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
