# Web per fitxar pels profes:
## Proposta:
Pàgina web que permetrà als professors autenticar-se amb el correu de l’institut per fitxar quan entren a treballar.
Aplicació mòvil (Android) que permetrà fitxar escanejant un codi QR

## Membres del grup:
Roger Pérez  
Adrian Villacis  
Anna Lea  
Sergio Castillero  

## Idea general del funcionament de la web:
La pàgina es servirà de manera local a la xarxa de l’institut, d’aquesta forma un professor que no estigui al centre no podrà accedir a la web per fitxar. 
El codi QR estarà o bé imprés o bé a una pantalla a l'escola per poder escanejar-lo en arribar.

## Funcionalitats:
### Pagina web: 
* Login mitjançant correu de l'institut, els professors nomès podràn fitxar, pero els perfils de gestió (direcció, cap d'estudis, etc) podràn monitoritzar les hores fitxades de cada docent.
* Horari dinàmic segons l'usuari (profe) loginejat.  
* Fitxar i desfitxar (per defecte si no desfitxes a última hora es farà sol,pero la possibilitat de fer-ho manualment permetrà que si un professor marxa a meitat del dia, es pugui registrar).
* Recompte d'hores setmanals de classe i comparaciò amb les hores fitxades.
### Aplicaciò mòvil: 
* Totes les funcionalitats de la pàgina.
* Fichar mitjançant codi QR, un botò, NFC, i possibles metodes que decidim ampliar.
* A la app se t'enviarà una push quan et toqui desfitxar, si no es desfitxa, segueix enviant pushes cada cop mes frequents. 

## Problemes/Riscos:
* Dificultats derivades d'utilitzar tecnologies noves.
* Alta probabilitat de no poder desenvolupar les ampliacions degut a la seva complexitat donat que no tenim cap experiencia en el tema.
* Integrar correctament l'aplicació movil i la pàgina web a l'hora.

## Tecnologies:
#### Frontend:
##### WEB:
* HTML
* Javascript
* Sass
* TailwindCSS (opcional)
* Svelte o Vue - (opcional)
##### APP: 
* Android Studio
* Java

#### Backend:
* php
* Laravel
* OAuth (logins)
* MySQL (dades)
> Rest API montada amb el framework Laravel per fer operacions CRUD

## Diagrama ER BBDD
![](https://i.imgur.com/2rfGsZV.png)

## MockAPI
[Link to mockAPI](https://jauth.docs.apiary.io)

#### Per què php?
Perque es el que aprendrém simultaneament a l'assignatura d'M07, de forma que podrém posar en pràctica els coneixements d'aquesta assignatura
#### Per què Laravel?
És el framework mes popular de php per aquest objectiu
#### Per què Sass?
Perque fa que la sintaxi del css sigui molt mès clara
#### Per què OAuth?
Incorpora login amb xarxes socials, que facilitarà autenticar-se amb el correu de l’institut
#### Per que MySQL?
Es el que sabem utilitzar i perque necessitem una base de dades relacional


## Availability:
Roger - 9h  
Adrian - 9h  
Anna - 6.5h  
Sergio - 9h

I hores extres que poguèm fer a casa
