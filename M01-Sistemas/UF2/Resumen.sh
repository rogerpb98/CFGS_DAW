#####################################################################################################################################
####################################(Q) 2.2.1: Exercicis de comandes de tractament de text.Pàgina####################################
#Mostra al terminal amb una única instrucció el contingut dels fitxers d'usuaris, contrasenyes i grups definits al sistema, numerant les seves línies. 
sudo cat -n /etc/passwd /etc/shadow /etc/group

#Mostra el contingut del fitxer .bashrc que es troba al teu directori home amb les ordres cat, more i less. Cerca amb la comanda less cada coincidència dintre del fitxer amb la paraula 'color' i assegura't que entens com passar d'una coincidència anterior a una posterior i viceversa. 
cat .bashrc; more .bashrc; less .bashrc (amb less, cercar amb '/' i 'n' per següent cerca o bé 'N' per a anterior cerca).
 Per cercar polsar la tecla / , desprès alternar entre polsar 'n' i 'N' per cerca anterior i posterior respectivament. 

#Mostra els 10 primers caràcters del fitxer /etc/environment
head -c10 /etc/environment

#Mostra les tres últimes i les tres primeres línies del fitxer /etc/grub.d/40_custom són iguals o diferents? Hi ha alguna línia que coincideixi en ambdues comandes?
tail -3 /etc/grub.d/40_custom ; head -3 /etc/grub.d/40_custom

#Mostra totes les línies del fitxer del fitxer /etc/crontab excepte les últimes 10 línies. 
head -n -10 /etc/crontab

#Mostra totes les línies del fitxer /etc/crontab exceptuant les 5 primeres. 
tail -n +6 /etc/crontab

#Cerca la línia en la que apareix emmagatzemat el teu usuari als fitxers d'usuaris i contrasenyes fent servir una única instrucció (OPCIONAL: per fer-ho més elegant fes servir la variable d'entorn $USER, o $USERNAME, en funció del sistema que tinguis).
sudo grep $USER /etc/passwd /etc/shadow

#Cerca al fitxers que conté els usuaris quina és la quantitat d'usuaris que tenen assignat el terminal de comandes /bin/bash
grep -c "/bin/bash" /etc/passwd  (no del tot encertada però en sintonia amb els coneixements de que disposem)  millor és:   grep -c ":/bin/bash$" /etc/passwd

#Mostra les dades del fitxer de contrasenyes dels usuaris que NO continguin al seu nom la lletra s.´
grep -v s /etc/shadow  (no del tot encertada però en sintonia amb els coneixements de que disposem)  millor és: 
sudo grep -ve "^[^:]*s[^:]*:" /etc/shadow (ja explicarem com funcionen expressions regulars).

#Mostra el número de línies que conté el fitxer /etc/fstab
wc -l /etc/fstab

#Amb una única instrucció, mostra el total de caràcters que hi ha a tots els arxius de text presents a l'escriptori (si no en tens crea dos o tres fitxers i omple'ls de text segons prefereixis, comprova que els resultats s'ajusten als que esperaves). `
wc -c ~/Escriptori/*.txt

#Fes que amb una comanda, tot text que s'escrigui en majúscules retorni a la pantalla en minúscules. 
tr [:upper:] [:lower:]

#Inventa amb una comanda un llenguatge nou, fes que per cada vocal que fiquis per teclat surti per pantalla la que la precedeix. Per exemple, si poso 'a' ha de sortir la 'e', si poso 'e' ha de sortir la 'i', i així successivament. Finalment, la 'u' per teclat mostrarà la 'a' per pantalla. 
tr aeiou eioua

#Fes les següents operacions amb l'arxiu oscar_age_female.csv (aquest fitxer conté dades sobre els oscars guanyats per diferents actrius del 1928 al 2016, així com la seva edat. L'ordre dels camps es: ID, ANY, EDAT, NOMACTRIU, NOMPELICULA)  :
a. sort -nr oscar_age_female.csv
b. sort -t, -k4r oscar_age_female.csv
c. sort -t, -k3n -k4r oscar_age_female.csv
d. cut -d, -f4-5 oscar_age_female.csv

###########################################################################################################################
####################################(Q) 2.4.1: Exercicis de pipes i redireccions.Pàgina####################################
#Envia la línia del teu usuari a /etc/passwd i /etc/shadow  a un fitxer anomentat dadesusuari.txt. Cadascuna de les dues línies ha d'estar numerada.
sudo cat /etc/passwd /etc/shadow | grep $USER | nl > dadesusuari.txt

sudo grep ^$USER: /etc/passwd /etc/shadow | nl > dadesusuari.txt

#Fent servir la comanda ls: Mostra tots els arxius amb extensió .txt que hi han als directoris i subdirectoris del teu directori 'home'.
ls -R ~ | grep .txt

#Mostra les sis primeres línies de l'ajuda per a la comanda help, ordena-les de la Z a la A i mostra-les  a través de la comanda 'less'
help help | head -6 | sort -r | less

#Fent servir la comanda cat: annexa kiwis, lichi i magrana al fitxer fruites.txt
cat >> fruites.txt

#Annexa totes les fruites que hi ha al fitxer fruites.txt en majúscula al propi fitxer fruites.txt.
cat fruites.txt | tr [:lower:] [:upper:] >> fruites.txt

#Recull en un fitxer de text anomenat error.txt totes les errades resultants d'executar la següent instrucció 'ls -R /'. La comanda no ha de mostrar res per pantalla, simplement generar el fitxer en qüestió.
ls -R / 2> error.txt > /dev/null

#El fitxer codificat.txt té un missatge secret. En una única línia de terminal, obté les dades d'aquest fitxer i decodifica la solució al fitxer decodificat.txt tenint en compte que: 
##El sistema de codificació emprat és codificació CESAR +4
##El alfabet emprat es: minúscules sense lletra ñ.
tr [d-zabc] [a-z] < codificat.txt > decodificat.txt

###############################################################################################################
####################################(Q) 2.5.1: Exercicis de cerca d'arxius.####################################
#Quin és el nom de l'arxiu d'ajuda de la comanda 'cut' i on està ubicat? Quina comanda has fet servir per a trobar-ho?
whereis cut

#Escriu la comanda necessària amb 'locate' per tal de trobar les següents dades:
#Només noms de fitxers que contenen la paraula 'gparted'.
locate gparted
#Quantitat de coincidències trobades (arxius i directoris) per a l'aplicació 'gparted'
locate -c gparted
#Quantitat de coincidències trobades (només arxius) per a l'aplicació 'gparted'
locate -cb gparted

#Crea un fitxer nou, tot seguit demostra que la comanda 'locate' no troba el fitxer en qüestió. Actualitza a continuació la base de dades de cerca indexada, fent servir la comanda corresponent, i mostra que, un cop actualitzada, la comanda 'locate' mostra l'arxiu.
touch f1.txt; locate f1.txt; sudo updatedb; locate f1.txt

#Cerca amb 'find' els següents arxius:
#Cerca arxius i directoris al directori /lib (i els seus subdirectoris) que continguin l'extensió '.so' 
find /lib -name *.so
#Cerca els scripts (fitxers amb extensió .sh) que hi hagi al directori /usr/lib, mostra els permisos de cada fitxer trobat.
find /usr/lib -type f -name *.sh -exec ls -l {} +
#Cerca els arxius i directoris que continguin al seu nom el text 'alsa' (en majúscules o minúscules) i que estiguin situats a directoris o subdirectoris de /usr/share/docs.
find /usr/share/docs -iname *alsa*
#Busca a tot el sistema '/' fitxers de mida superior a 50MiB. Redirigeix els errors de la comanda a /dev/null
find / -size +50M 2>/dev/null
#Cerca a tot el sistema '/' només fitxers (no incloguis directoris) de mida inferior a 100KiB.
find / -size -100K    ... o bé ... find / -size -100k -filetype f
#Cerca a tot el sistema '/' només directoris (no incloguis fitxers) O BÉ arxius de mida inferior a 100KiB.
find / -type d -or -size -100K
#Cerca directoris dins del teu directori (o subdirectoris ubicats a) home '~',als quals el propietari sigui el teu usuari. Mostra els seus permisos juntament amb la sortida de la comanda.
find ~ -user $USER -type d -ls
#Cerca els fitxers al directori /root que són propietat de l'usuari 'root'. Tot seguit, mostra per sortida el nom de l'arxiu i el número de línies que conté cadascun.
find /root -user root -exec wc -l {} +

###################################################################################################################
####################################(Q) 2.7.1. Exemples d'expressions regulars.####################################
#Expressió que permeti detectar codis postals. 
^(0[1-9]|[1-4]\d|5[0-2])\d{3}$

#Expressió que permeti detectar DNI.  
^[0-9]{8,8}[A-Za-z]$
^[0-9]{8}[A-Za-z]$

#Expressió que permeti detectar un valor numèric entre 0 i 49.
^[0-4]?[0-9]$
^[0-4]?\d$

#Expressió que permeti detectar un valor numèric entre 0 i 100.
^([0-9]{1,2}|100)$

#Expressió que permeti detectar un valor numèric entre 1 i 100. 
^([1-9][0-9]|100?)$
^([1-9]\d?|100)$

#Expressió que permeti detectar un valor numèric entre 0 i 199.
 [0,1]?[0-9]{1,2}$
 ^1?\d{1,2}$

#Expressió que permet detectar un valor numèric entre 0 i 45.
^([0-3]?\d|4[0-5])$

#Expressió que permeti detectar un valor numèric entre 0 i 255.
^([0-1]?\d{1,2}|2[0-4]\d|25[0-5])$