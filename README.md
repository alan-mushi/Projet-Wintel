# Projet Wintel

<br />
## Description

Cette application est apparentée à un annuaire électronique. Elle permet de gérer ses contacts et de les contacter.
L'annuaire est doté d'une interface graphique pour la gestion des contacts.<br />
Une liste des contacts pré-établie est fournie : `ww/table.bin`.

<br />
## Stade du développement

* Toutes les action demandées ont été réalisées.
* Nous avons réalisé deux des points de travail supplémentaire.

<br />
## Toute la javadoc est à générer sur sa propre machine !

Depuis le dossier racine du projet.<br />
Commande javadoc : `javadoc -docencoding utf8 -charset utf8 -private -d doc/ src/datas/* src/ihm/*`<br />
Le fichier `javadoc.sh` contient la commande et plus...
Le fichier `ww/compile.sh` permet de compiler avec le bon encodage puis donne le choix d'exécuter ou non Wintel.

<br />
## Travail additionnel effectué

* Rajouter le champ « adresse » pour un contact téléphonique.
* Proposer un codage conforme au modèle MVC vu en cours.

<br />
## Auteurs

* CLAUDIC Guillaume - zipang29
* GUITTET Thibault - alan-mushi
