En aquest exercici et demano que construeixis expressions de les següents afirmacions.

Pots fer servir tots els operadors aritmètics, relacionals i els lògics &&, || i !.

En alguns casos, podràs simplificar les expressions fent servir operadors relacionals diferents. Et proposo que incloguis les dues (o més opcions) de manera que practiquis els operadors lògics. Per la mateixa raó, intenta evitar necessitar crear variables temporals.
=======
* la Clara és més jove que tu
edatClara < edatMeva

* la Clara i el Marc són més joves que tu
edatClara < edatMeva && edatMarc < edatMeva

* la Clara és més jove que tu i tu ets més jove que el Marc
edatClara < edatMeva && edatMeva < edatMarc

* la Clara no és més jove que el Marc
edatClara >= edatMarc

* no és cert que el Marc sigui més jove que la Clara
edatMarc >= edatClara

* Ni el Marc és més jove que la Clara ni tu ets més jove que el Marc
edatMarc >= edatClara && edatMeva >= edatMarc

* Tu ets més gran que la Clara i el Marc junts o bé la Clara i el Marc tenen la mateixa edat
edatMeva > (edatClara + edatMarc) || edatClara == edatMarc

Afegeix al menys 2 (dos) noves afirmacions de la teva collita i les expressions corresponents. Si ja n’has tingut prou d’edats, pots fer servir altres conceptes com ara la temperatura, el pes…

* La meva edat es major que la de la Clara i el Marc junts i l'edat del Marc es major que la de la Clara
edatMeva > (edatClara + edatMarc) && edatMarc > edatClara

* La edat del Marc es menys que la meitat de l'edat de la Clara
edatMarc < (edatClara / 2)
